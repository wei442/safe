package com.cloud.queue.safe.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloud.common.exception.RedisException;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

public interface IRedisService {

	// TODO 键(key) 命令工具方法
	/************************** jredis 键(key) 命令工具方法 ****************************/
	/**
	 * 删除给定的一个 key,不存在的 key会被忽略
	 * @param keys
	 * @return long 返回 被删除 key 的数量
	 */
	public long del(String... keys) throws RedisException;

	/**
	 * 序列化给定 key ，并返回被序列化的值
	 * @param key
	 * @return byte[]
	 * @throws RedisException
	 */
	public byte[] dump(String key) throws RedisException;

	/**
	 * 检查给定 key 是否存在
	 * @param key
	 * @return boolean 若 key 存在返回 true，否则返回 false
	 */
	public boolean exists(String key) throws RedisException;

	/**
	 * 检查给定 多个key 是否存在
	 * @param keys
	 * @return long 返回key的数量
	 */
	public long exists(String... keys) throws RedisException;

	/**
	 * 命令用于设置 单个key 的过期时间，以秒计。key 过期后将不再可用
	 * @param key
	 * @param seconds 秒
	 * @return long 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
	 */
	public long expire(String key, int seconds) throws RedisException;

	/**
	 * 命令用于设置 单个key 的过期时间，以秒计。key 过期后将不再可用。时间参数是UNIX时间戳(unix timestamp)。
	 * @param key
	 * @param unixTime
	 * @return long
	 * @throws RedisException
	 */
	public long expireAt(String key, long unixTime) throws RedisException;

	/**
	 * 命令用于查找所有符合给定模式 pattern 的 key
	 * @param pattern
	 * @return Set<String> 符合给定模式的 key 列表 (Array)
	 */
	public Set<String> keys(String pattern) throws RedisException;

	/**
	 * 将当前数据库的key移动到给定的数据库db当中
	 * @param key
	 * @param dbIndex
	 * @return long 移动成功返回 1 ，失败则返回 0 。
	 * @throws RedisException
	 */
	public long move(String key,int dbIndex) throws RedisException;

	/**
	 * 移除给定 key 的生存时间，将这个 key 从『易失的』(带生存时间 key )转换成『持久的』(一个不带生存时间、永不过期的 key )。
	 * @param key
	 * @return long 当生存时间移除成功时，返回 1 .如果 key 不存在或 key 没有设置生存时间，返回 0 。
	 */
	public long persist(String key) throws RedisException;

	/**
	 * 将key原子性地从当前实例传送到目标实例的指定数据库上，一旦传送成功， key 保证会出现在目标实例上，而当前实例上的 key 会被删除
	 * @param host
	 * @param port
	 * @param key
	 * @param destinationDb
	 * @param timeout
	 * @return String
	 * @throws RedisException
	 */
	public String migrate(String host, int port, String key, int destinationDb, int timeout) throws RedisException;

	/**
	 * 命令用于设置 key 的过期时间，以毫秒计。key 过期后将不再可用
	 * @param key
	 * @param milliseconds
	 * @return long 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
	 */
	public long pexpire(String key, long milliseconds) throws RedisException;

	/**
	 * 命令用于设置 key 的过期时间，以毫秒计。key 过期后将不再可用。时间参数是UNIX时间戳(unix timestamp)。
	 * @param key
	 * @param milliseconds
	 * @return long 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0
	 */
	public long pexpireAt(String key, long millisecondsTimestamp) throws RedisException;

	/**
	 * 以毫秒为单位返回 key 的剩余生存时间
	 * @param key
	 * @return long 当 key 不存在时，返回 -2。当 key 存在但没有设置剩余生存时间时，返回 -1。否则，以毫秒为单位，返回 key 的剩余生存时间
	 */
	public long pttl(String key) throws RedisException;

	/**
	 * 从当前数据库中随机返回(不删除)一个 key 。
	 * @return String 当数据库不为空时，返回一个 key 。当数据库为空时，返回 nil 。
	 */
	public String randomKey() throws RedisException;

	/**
	 * 用于修改 key 的名称
	 * @param oldkey
	 * @param newkey
	 * @return String
	 * 改名成功时提示 OK ，失败时候返回一个错误
	 * 当 OLD_KEY_NAME 和 NEW_KEY_NAME 相同，或者 OLD_KEY_NAME 不存在时，返回一个错误。 当 NEW_KEY_NAME 已经存在时， RENAME 命令将覆盖旧值
	 */
	public String rename(String oldkey, String newkey) throws RedisException;

	/**
	 * 在新的 key 不存在时修改 key 的名称
	 * @param oldkey
	 * @param newkey
	 * @return long 修改成功时，返回 1 。 如果 NEW_KEY_NAME 已经存在，返回 0 。
	 */
	public long renamenx(String oldkey, String newkey) throws RedisException;

	/**
	 * 反序列化给定的序列化值，并将它和给定的 key 关联
	 * 参数 ttl 以毫秒为单位为 key 设置生存时间；如果 ttl 为 0 ，那么不设置生存时间。
	 * 如果键 key 已经存在， 并且给定了 REPLACE 选项， 那么使用反序列化得出的值来代替键 key 原有的值； 相反地， 如果键 key 已经存在， 但是没有给定 REPLACE 选项， 那么命令返回一个错误。
	 * @param key
	 * @param ttl
	 * @param serializedValue
	 * @return String 如果反序列化成功那么返回 OK ，否则返回一个错误
	 */
	public String restore(String key, int ttl, byte[] serializedValue) throws RedisException;

	/**
	 * 排序默认以数字作为对象，值被解释为双精度浮点数，然后进行比较。
	 * @param key
	 * @param sortingParameters
	 * @param dstkey
	 * @return long 返回或保存给定列表、集合、有序集合 key 中经过排序的元素
	 */
	public long sort(String key, SortingParams sortingParameters, String dstkey) throws RedisException;

	/**
	 * 以秒为单位返回 key 的剩余过期时间
	 * @param key
	 * @return long 当 key 不存在时，返回 -2。当 key 存在但没有设置剩余生存时间时，返回 -1。否则，以秒为单位，返回 key 的剩余生存时间。
	 */
	public long ttl(String key) throws RedisException;

	/**
	 * 返回 key 所储存的值的类型
	 * @param key
	 * @return String
	 */
	public String type(String key) throws RedisException;

	/**
	 * 用于迭代当前数据库中的数据库键。
	 * @param cursor
	 * @return ScanResult<String>
	 * @throws RedisException
	 */
	public ScanResult<String> scan(String cursor) throws RedisException;

	/**
	 * 用于迭代当前数据库中的数据库键。
	 * @param cursor
	 * @param params
	 * @return ScanResult<String>
	 * @throws RedisException
	 */
	public ScanResult<String> scan(String cursor,ScanParams params) throws RedisException;

	/************************** jredis 键(key) 命令工具方法 ****************************/

	// TODO String(字符串) 命令工具方法
	/************************** jredis String(字符串) 命令工具方法 ****************************/
	/**
	 * 用于为指定的 key 追加值
	 * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
	 * 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样
	 * @param key
	 * @param value
	 * @return long 追加指定值之后， key 中字符串的长度
	 */
	public long append(String key, String value) throws RedisException;

	/**
	 * 计算给定字符串中，被设置为1的比特位的数量。
	 * @param key
	 * @return long 被设置为1的位的数量。
	 * @throws RedisException
	 */
	public long bitcount(String key) throws RedisException;

	/**
	 * 计算给定字符串中，被设置为1的比特位的数量。
	 * @param key
	 * @param start
	 * @param end
	 * @return long
	 * @throws RedisException
	 */
	public long bitcount(String key, long start, long end) throws RedisException;

	/**
	 * 对一个或多个保存二进制位的字符串key进行位元操作
	 * @param op
	 * @param destKey
	 * @param srcKeys
	 * @return long
	 * @throws RedisException
	 */
	public long bitop(BitOP op, String destKey, String... srcKeys) throws RedisException;

	/**
	 * 可以将一个Redis字符串看作是一个由二进制位组成的数组，并对这个数组中储存的长度不同的整数进行访问
	 * @param key
	 * @param arguments
	 * @return List<Long> 返回值是一个数组， 数组中的每个元素对应一个被执行的子命令
	 * @throws RedisException
	 */
	public List<Long> bitfield(String key, String... arguments) throws RedisException;

	/**
	 * 将 key 中储存的数字值减一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * @param key
	 * @return long 执行命令之后 key 的值。
	 */
	public long decr(String key) throws RedisException;

	/**
	 * 将 key 所储存的值减去指定的减量值。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * @param key
	 * @param value
	 * @return long 减去指定减量值之后， key 的值。
	 */
	public long decrBy(String key, int value) throws RedisException;

	/**
	 * 用于获取指定 key 的值。如果 key 不存在，返回 nil 。如果key 储存的值不是字符串类型，返回一个错误
	 * @param key
	 * @return String 返回 key 的值，如果 key 不存在时，返回 nil。 如果 key 不是字符串类型，那么返回一个错误。
	 */
	public String get(String key) throws RedisException;

	/**
	 * 对key所储存的字符串值，获取指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @return Boolean 字符串值指定偏移量上的位(bit)
	 * @throws RedisException
	 */
	public Boolean getbit(String key, long offset) throws RedisException;

	/**
	 * 用于获取存储在指定 key 中字符串的子字符串。字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。
	 * 负数偏移量表示从字符串最后开始计数， -1 表示最后一个字符， -2 表示倒数第二个，以此类推
	 * @param key
	 * @param startOffset
	 * @param endOffset
	 * @return String 截取得到的子字符串
	 */
	public String getrange(String key, long startOffset, long endOffset) throws RedisException;

	/**
	 * 用于设置指定 key 的值，并返回 key 旧的值
	 * @param key
	 * @param value
	 * @return String 返回给定 key 的旧值。 当 key 没有旧值时，即 key 不存在时，返回 nil。当 key 存在但不是字符串类型时，返回一个错误。
	 */
	public String getSet(String key, String value) throws RedisException;

	/**
	 * 将 key 中储存的数字值增一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * @param key
	 * @return long 执行 INCR 命令之后 key 的值。
	 */
	public long incr(String key) throws RedisException;

	/**
	 * 将 key 中储存的数字加上指定的增量值。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * @param key
	 * @param value
	 * @return long 加上指定的增量值之后， key 的值。
	 */
	public long incrBy(String key, int value) throws RedisException;

	/**
	 * 为 key 中所储存的值加上指定的浮点数增量值。如果 key 不存在，那么 INCRBYFLOAT 会先将 key 的值设为 0 ，再执行加法操作。
	 * @param key
	 * @param value
	 * @return 执行命令之后 key 的值。
	 */
	public double incrByFloat(String key, double value) throws RedisException;

	/**
	 * 返回所有(一个或多个)给定 key 的值。 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil
	 * @param key
	 * @return List<String> 一个包含所有给定 key 的值的列表
	 */
	public List<String> mget(String... key) throws RedisException;


	/**
	 * 用于同时设置一个或多个 key-value
	 * 如果某个给定 key 已经存在，那么 MSET 会用新值覆盖原来的旧值
	 * MSET 是一个原子性(atomic)操作，所有给定 key 都会在同一时间内被设置，某些给定 key 被更新而另一些给定 key 没有改变的情况，不可能发生。
	 * @param keysvalues
	 * @return String 总是返回 OK
	 */
	public String mset(String... keysvalues) throws RedisException;

	/**
	 * 所有给定 key 都不存在时，同时设置一个或多个 key-value 对
	 * MSETNX 是原子性的
	 * @param keysvalues
	 * @return long 当所有 key 都成功设置，返回 1 。 如果所有给定 key 都设置失败(至少有一个 key 已经存在)，那么返回 0
	 */
	public long msetnx(String... keysvalues) throws RedisException;

	/**
	 * 以毫秒为单位设置 key 的生存时间
	 * @param key
	 * @param seconds
	 * @param value
	 * @return String 设置成功时返回 OK
	 */
	public String psetex(String key, long seconds, String value) throws RedisException;

	/**
	 * 用于设置给定 key 的值。如果 key 已经存储其他值， SET 就覆写旧值，且无视类型
	 * @param key
	 * @param value
	 * @return String
	 * 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK
	 * 从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK
	 */
	public String set(String key, String value) throws RedisException;

	/**
	 * 用于设置给定 key的值。如果 key 已经存储其他值， SET 就覆写旧值，且无视类型
	 * @param key
	 * @param value
	 * @param nxxx
	 * @return String
	 * @throws RedisException
	 * 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK
	 * 从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK
	 * EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
	 * PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
	 * NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
	 * XX ：只在键已经存在时，才对键进行设置操作。
	 */
	public String set(String key, String value, String nxxx) throws RedisException;

	/**
	 * 用于设置给定 key的值。如果 key 已经存储其他值， SET 就覆写旧值，且无视类型
	 * @param key
	 * @param value
	 * @param nxxx
	 * @param expx
	 * @param time
	 * @return String
	 * @throws RedisException
	 * 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK
	 * 从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK
	 * EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
	 * PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
	 * NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
	 * XX ：只在键已经存在时，才对键进行设置操作。
	 */
	public String set(String key, String value, String nxxx, String expx, long time) throws RedisException;

	/**
	 * 对key所储存的字符串值，设置或清除指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @param value
	 * @return Boolean
	 * @throws RedisException
	 */
	public Boolean setbit(String key, long offset, String value) throws RedisException;

	/**
	 * 对key所储存的字符串值，设置或清除指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @param value
	 * @return Boolean
	 * @throws RedisException
	 */
	public Boolean setbit(String key, long offset, boolean value) throws RedisException;

	/**
	 * 为指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值
	 * @param key
	 * @param seconds
	 * @param value
	 * @return String 设置成功时返回 OK,当 seconds 参数不合法时，返回一个错误。
	 */
	public String setex(String key, int seconds, String value) throws RedisException;

	/**
	 * 在指定的 key 不存在时，为 key 设置指定的值;若给定的 key 已经存在，则 SETNX 不做任何动作。
	 * @param key
	 * @param value
	 * @return long 设置成功，返回 1 。 设置失败，返回 0 。
	 */
	public long setnx(String key, String value) throws RedisException;

	/**
	 * 用指定的字符串覆盖给定 key 所储存的字符串值，覆盖的位置从偏移量 offset 开始
	 * 不存在的 key 当作空白字符串处理
	 * @param key
	 * @param offset
	 * @param value
	 * @return long 被修改后的字符串长度
	 */
	public long setrange(String key, long offset, String value) throws RedisException;
	/**
	 * 用于获取指定 key 所储存的字符串值的长度。当 key 储存的不是字符串值时，返回一个错误
	 * @param key
	 * @return long 字符串值的长度。 当 key 不存在时，返回 0
	 */
	public long strlen(String key) throws RedisException;

	/************************** jredis String(字符串) 命令工具方法 ****************************/

	// TODO Hash(哈希表) 命令工具方法
	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/
	/**
	 * 用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略。
	 * @param key
	 * @param fields
	 * @return long 被成功删除字段的数量，不包括被忽略的字段。
	 */
	public long hdel(String key, String... fields) throws RedisException;

	/**
	 * 查看哈希表的指定字段是否存在。
	 * @param key
	 * @param field
	 * @return boolean 如果哈希表含有给定字段，返回 true 。 如果哈希表不含有给定字段，或 key 不存在，返回 false。
	 */
	public boolean hexists(String key, String field) throws RedisException;

	/**
	 * 用于返回哈希表中指定字段的值。
	 * @param key
	 * @param field
	 * @return String 返回给定字段的值。如果给定的字段或 key 不存在时，返回 nil 。
	 */
	public String hget(String key, String field) throws RedisException;

	/**
	 * 用于返回哈希表中，所有的字段和值。在返回值里，紧跟每个字段名(field name)之后是字段的值(value)，所以返回值的长度是哈希表大小的两倍。
	 * @param key
	 * @return Map<String, String> 以列表形式返回哈希表的字段及字段值。 若 key 不存在，返回空列表。
	 */
	public Map<String, String> hgetAll(String key) throws RedisException;

	/**
	 * 为哈希表中的字段值加上指定增量值。增量也可以为负数，相当于对指定字段进行减法操作。如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
	 * 如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误。本操作的值被限制在 64 位(bit)有符号数字表示之内。
	 * @param key
	 * @param field
	 * @param value
	 * @return long 执行 HINCRBY 命令之后，哈希表中字段的值。
	 */
	public long hincrBy(String key, String field, long value) throws RedisException;

	/**
	 * 为哈希表中的字段值加上指定浮点数增量值。如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
	 * @param key
	 * @param field
	 * @param value
	 * @return double 执行 Hincrbyfloat 命令之后，哈希表中字段的值
	 */
	public double hincrByFloat(String key, String field, double value) throws RedisException;

	/**
	 * 用于获取哈希表中的所有字段名。
	 * @param key
	 * @return Set<String> 包含哈希表中所有字段的列表。 当 key 不存在时，返回一个空列表。
	 */
	public Set<String> hkeys(String key) throws RedisException;

	/**
	 * 获取哈希表中字段的数量。
	 * @param key
	 * @return long 当 key 不存在时，返回 0 。
	 */
	public long hlen(String key) throws RedisException;

	/**
	 * 用于返回哈希表中，一个或多个给定字段的值。如果指定的字段不存在于哈希表，那么返回一个 nil 值。
	 * @param key
	 * @param fields
	 * @return List<String> 一个包含多个给定字段关联值的表，表值的排列顺序和指定字段的请求顺序一样。
	 */
	public List<String> hmget(String key, String... fields) throws RedisException;

	/**
	 * 用于同时将多个 field-value (字段-值)对设置到哈希表中。此命令会覆盖哈希表中已存在的字段。如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作。
	 * @param key
	 * @param hash
	 * @return String 如果命令执行成功，返回 OK 。
	 */
	public String hmset(String key, Map<String, String> hash) throws RedisException;

	/**
	 * 为哈希表中的字段赋值 。如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。如果字段已经存在于哈希表中，旧值将被覆盖
	 * @param key
	 * @param field
	 * @param value
	 * @return long 如果字段是哈希表中的一个新建字段，并且值设置成功，返回 1 。 如果哈希表中域字段已经存在且旧值已被新值覆盖，返回 0 。
	 */
	public long hset(String key, String field, String value) throws RedisException;

	/**
	 * 用于为哈希表中不存在的的字段赋值 。如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果字段已经存在于哈希表中，操作无效。如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
	 * @param key
	 * @param field
	 * @param value
	 * @return long 设置成功，返回 1 。 如果给定字段已经存在且没有操作被执行，返回 0 。
	 */
	public long hsetnx(String key, String field, String value) throws RedisException;

	/**
	 * 返回哈希表所有字段的值。
	 * @param key
	 * @return List<String> 一个包含哈希表中所有值的表。 当 key 不存在时，返回一个空表。
	 */
	public List<String> hvals(String key) throws RedisException;

	/**
	 * 用于迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @return ScanResult<Map.Entry<String, String>>
	 * @throws RedisException
	 */
	public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) throws RedisException;

	/**
	 * 用于迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @param params
	 * @return ScanResult<Map.Entry<String, String>>
	 * @throws RedisException
	 */
	public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) throws RedisException;

	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/

	// TODO List(列表) 命令工具方法
	/************************** jredis List(列表) 命令工具方法 ****************************/
	/**
	 * 不超时移除并返回列表的第一个元素
	 * @param key
	 * @return 如果列表为空，返回一个 nil 。 否则，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
	 */
	public String blpop(String... key) throws RedisException;

	/**
	 * 根据超时时间 移除并返回列表的第一个元素
	 * @param timeout
	 * @param key
	 * @return String 如果列表为空，返回一个 nil 。 否则，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
	 */
	public String blpop(int timeout,String... key) throws RedisException;


	/**
	 * 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。不超时
	 * @param key
	 * @return String 假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
	 */
	public String brpop(String... key) throws RedisException;

	/**
	 * 根据超时时间 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
	 * @param timeout
	 * @param key
	 * @return String 假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
	 */
	public String brpop(int timeout,String... key) throws RedisException;

	/**
	 * 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 * 超时参数 timeout 接受一个以秒为单位的数字作为值。超时参数设为 0 表示阻塞时间可以无限期延长(block indefinitely) 。
	 * @param source
	 * @param destination
	 * @param timeout
	 * @return String 假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素的值，第二个元素是等待时长。
	 */
	public String brpoplpush(String source, String destination, int timeout) throws RedisException;

	/**
	 * 用于通过索引获取列表中的元素。你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * @param key
	 * @param index
	 * @return String 列表中下标为指定索引值的元素。 如果指定索引值不在列表的区间范围内，返回 nil 。
	 */
	public String lindex(String key, long index) throws RedisException;

	/**
	 * 在列表的元素前或者后插入元素。 当指定元素不存在于列表中时，不执行任何操作。 当列表不存在时，被视为空列表，不执行任何操作。 如果 key 不是列表类型，返回一个错误
	 * @param key
	 * @param where
	 * @param pivot
	 * @param value
	 * @return long 如果命令执行成功，返回插入操作完成之后，列表的长度。 如果没有找到指定元素 ，返回 -1 。 如果 key 不存在或为空列表，返回 0 。
	 */
	public long linsert(String key, LIST_POSITION where, String pivot, String value) throws RedisException;

	/**
	 * 用于返回列表的长度。 如果列表 key 不存在，则 key 被解释为一个空列表，返回 0 。 如果 key 不是列表类型，返回一个错误。
	 * @param key
	 * @return long 返回列表的长度
	 */
	public long llen(String key) throws RedisException;

	/**
	 * 移除并返回列表 key 的头元素
	 * @param key
	 * @return String 列表的头元素。当 key 不存在时，返回 nil 。
	 */
	public String lpop(String key) throws RedisException;

	/**
	 * 将一个或多个值插入到列表头部。 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
	 * 注意：在Redis 2.4版本以前的 LPUSH 命令，都只接受单个 value 值。
	 * @Title: lpush
	 * @Description: 存储REDIS队列 -左进
	 * @param key
	 * @param values
	 * @return long 执行 LPUSH 命令后，列表的长度。
	 */
	public long lpush(String key, String... values) throws RedisException;


	/**
	 * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。
	 * 和 LPUSH 命令相反，当 key 不存在时， LPUSHX 命令什么也不做。
	 * @param key
	 * @param values
	 * @return long
	 */
	public long lpushx(String key, String... values) throws RedisException;

	/**
	 * 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。
	 * 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * @param key
	 * @param from
	 * @param to
	 * @return List<String> 一个列表，包含指定区间内的元素
	 */
	public List<String> lrange(String key, long from, long to) throws RedisException;

	/**
	 * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
	 * count 的值可以是以下几种：
	 * count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
	 * count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
	 * count = 0 : 移除表中所有与 value 相等的值。
	 * @param key
	 * @param count
	 * @param value
	 * @return long 被移除元素的数量。因为不存在的 key 被视作空表(empty list)，所以当 key 不存在时， LREM 命令总是返回 0 。
	 */
	public long lrem(String key, long count, String value) throws RedisException;

	/**
	 * 通过索引来设置元素的值。当索引参数超出范围，或对一个空列表进行 LSET 时，返回一个错误
	 * @param key
	 * @param index
	 * @param value
	 * @return 操作成功返回 ok ，否则返回错误信息。
	 */
	public String lset(String key, long index, String value) throws RedisException;

	/**
	 * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
	 * 举个例子，执行命令 LTRIM list 0 2 ，表示只保留列表 list 的前三个元素，其余元素全部删除。
	 * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * 当 key 不是列表类型时，返回一个错误。
	 * @param key
	 * @param start
	 * @param end
	 * @return String 命令执行成功时，返回 ok 。
	 */
	public String ltrim(String key, long start, long end) throws RedisException;

	/**
	 * 移除并返回列表的最后一个元素。获取队列数据，不阻塞
	 * @param key
	 * @return String 列表的最后一个元素。 当列表不存在时，返回 nil 。
	 */
	public String rpop(String key) throws RedisException;

	/**
	 * 将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端。将 source 弹出的元素插入到列表 destination ，作为 destination 列表的的头元素。
	 * @param srckey
	 * @param dstkey
	 * @return String 被弹出的元素。
	 */
	public String rpoplpush(String srckey, String dstkey) throws RedisException;

	/**
	 * 用于将一个或多个值插入到列表的尾部(最右边)。如果列表不存在，一个空列表会被创建并执行 RPUSH 操作。 当列表存在但不是列表类型时，返回一个错误。注意：在 Redis 2.4 版本以前的 RPUSH 命令，都只接受单个 value 值。
	 * 存储REDIS队列 反向存储
	 * @param key
	 * @param values
	 * @return long 执行 RPUSH 操作后，列表的长度。
	 */
	public long rpush(String key, String... values) throws RedisException;

	/**
	 * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。
	 * 和 RPUSH 命令相反，当 key 不存在时， RPUSHX 命令什么也不做。
	 * @param key
	 * @param values
	 * @return long 命令执行之后，表的长度。
	 */
	public long rpushx(String key, String... values) throws RedisException;
	/************************** jredis List(列表) 命令工具方法 ****************************/

	// TODO Set(集合) 命令工具方法
	/************************** jredis Set(集合) 命令工具方法 ****************************/
	/**
	 * Redis Sadd 命令将一个或多个成员元素加入到集合中，已经存在于集合的成员元素将被忽略。
	 * 假如集合 key 不存在，则创建一个只包含添加的元素作成员的集合。
	 * 当集合 key 不是集合类型时，返回一个错误。
	 * 注意：在Redis2.4版本以前， SADD 只接受单个成员值。
	 * @param key		reids键名
	 * @param members	集合元素
	 * @return 操作成功返回被添加到集合中的新元素的数量，不包括被忽略的元素
	 */
	public long sadd(String key, String... members) throws RedisException;

	/**
	 * Redis Scard 命令返回集合中元素的数量
	 * @param key		reids键名
	 * @return 操作成功返回集合的数量,当集合 key不存在时，返回 0
	 */
	public long scard(String key) throws RedisException;

	/**
	 * Redis Sdiff 命令返回给定集合之间的差集。不存在的集合 key 将视为空集
	 * @param keys		reids键名
	 * @return 操作成功返回包含差集成员的列表
	 */
	public Set<String> sdiff(String... keys) throws RedisException;

	/**
	 * Redis Sdiffstore 命令将给定集合之间的差集存储在指定的集合中。如果指定的集合 key 已存在，则会被覆盖。
	 * @param dstkey	目标集合键名
	 * @param keys		差集集合键名
	 * @return 结果集中的元素数量。
	 */
	public long sdiffstore(String dstkey, String... keys) throws RedisException;

	/**
	 * Redis Sinter 命令返回给定所有给定集合的交集。 不存在的集合 key 被视为空集。
	 * 当给定集合当中有一个空集时，结果也为空集(根据集合运算定律)。
	 * @param keys		reids键名
	 * @return 交集成员的列表
	 */
	public Set<String> sinter(String... keys) throws RedisException;

	/**
	 * Redis Sinterstore 命令将给定集合之间的交集存储在指定的集合中。如果指定的集合已经存在，则将其覆盖。
	 * @param dstkey	目标集合键名
	 * @param keys		差集集合键名
	 * @return 结果集中的元素数量。
	 */
	public long sinterstore(String dstkey, String... keys) throws RedisException;

	/**
	 * Redis Sismember 命令判断成员元素是否是集合的成员。
	 * @param key		键名
	 * @param member	判断元素
	 * @return 如果成员元素是集合的成员，返回 true 。 如果成员元素不是集合的成员，或 key 不存在，返回false
	 */
	public boolean sismember(String key, String member) throws RedisException;

	/**
	 * Redis Smembers 命令返回集合中的所有的成员。 不存在的集合 key 被视为空集合。
	 * @param key		reids键名
	 * @return 集合中的所有成员
	 */
	public Set<String> smembers(String key) throws RedisException;

	/**
	 * Redis Smove 命令将指定成员 member 元素从 source 集合移动到 destination 集合。
	 * SMOVE 是原子性操作。
	 * 如果 source 集合不存在或不包含指定的 member 元素，则 SMOVE 命令不执行任何操作，仅返回 0 。否则， member 元素从 source 集合中被移除，并添加到 destination 集合中去。
	 * 当 destination 集合已经包含 member 元素时， SMOVE 命令只是简单地将 source 集合中的 member 元素删除。
	 * 当 source 或 destination 不是集合类型时，返回一个错误
	 * @param srckey		原集合键名
	 * @param dstkey		目标集合键名
	 * @param member		移动元素
	 * @return 如果成员元素被成功移除，返回 1 。 如果成员元素不是 source 集合的成员，并且没有任何操作对 destination 集合执行，那么返回 0
	 */
	public long smove(String srckey, String dstkey, String member) throws RedisException;

	/**
	 * Redis Spop 命令用于移除并返回集合中的一个随机元素
	 * @param key		键名
	 * @return 被移除的随机元素。 当集合不存在或是空集时，返回 null
	 */
	public String spop(String key) throws RedisException;

	/**
	 * Redis Spop 命令用于移除并返回集合中的多个随机元素
	 * @param key		键名
	 * @param count		元素个数
	 * @return 被移除的随机元素。 当集合不存在或是空集时，返回空
	 */
	public Set<String> spop(String key, long count) throws RedisException;

	/**
	 * Redis Srandmember 命令用于返回集合中的一个随机元素。
	 * 该操作和 SPOP 相似，但 SPOP 将随机元素从集合中移除并返回，而 Srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
	 * @param key		键名
	 * @return 如果集合为空，返回null。
	 */
	public String srandmember(String key) throws RedisException;

	/**
	 * Redis Srandmember 命令用于返回集合中的一个随机元素。
	 * 从 Redis 2.6 版本开始， Srandmember 命令接受可选的 count 参数：
	 * 如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
	 * 如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。
	 * 该操作和 SPOP 相似，但 SPOP 将随机元素从集合中移除并返回，而 Srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
	 * @param key		键名
	 * @param count		元素个数
	 * @return 那么返回一个数组；如果集合为空，返回空数组
	 */
	public List<String> srandmember(String key, int count) throws RedisException;

	/**
	 * Redis Srem 命令用于移除集合中的一个或多个成员元素，不存在的成员元素会被忽略。
	 * 当 key 不是集合类型，返回一个错误。
	 * 在 Redis 2.4 版本以前， SREM 只接受单个成员值
	 * @param key		键名
	 * @param members	元素
	 * @return 被成功移除的元素的数量，不包括被忽略的元素
	 */
	public long srem(String key, String... members) throws RedisException;

	/**
	 * Redis Sunion 命令返回给定集合的并集。不存在的集合 key 被视为空集
	 * @param keys		键名
	 * @return 并集成员的列表
	 */
	public Set<String> sunion(String... keys) throws RedisException;

	/**
	 * Redis Sunionstore 命令将给定集合的并集存储在指定的集合 destination中。
	 * @param dstkey	目标集合键名
	 * @param keys		差集集合键名
	 * @return 结果集中的元素数量。
	 */
	public long sunionstore(String dstkey, String... keys) throws RedisException;

	/**
	 * Redis Sscan 命令用于迭代集合键中的元素。
	 * @param key		目标集合键名
	 * @param cursor	游标
	 * @return 数组列表。
	 */
	public ScanResult<String> sscan(String key, String cursor) throws RedisException;

	/**
	 * Redis Sscan 命令用于迭代集合键中的元素。
	 * @param key			目标集合键名
	 * @param cursor		游标
	 * @param ScanParams	迭代参数
	 * @return 数组列表。
	 */
	public ScanResult<String> sscan(String key, String cursor, ScanParams params) throws RedisException;

	/************************** jredis Set(集合) 命令工具方法 ****************************/

	// TODO SortedSet(有序集合) 命令工具方法
	/************************** jredis SortedSet(有序集合) 命令工具方法 ****************************/
	/**
	 * 存储REDIS 有序集合-按分数值添加
	 * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
	 * @param String key reids键名
	 * @param double score 	分数值(排序值)
	 * @param String member 元素
	 */
	public long zadd(String key, double score, String member) throws RedisException;

	/**
	 * 将一个member 元素及其 score 值加入到有序集 key 当中。
	 * @param key
	 * @param score
	 * @param member
	 * @param params
	 * @return long
	 * @throws RedisException
	 */
	public long zadd(String key, double score, String member, ZAddParams params) throws RedisException;

	/**
	 * 将多个member元素及其 score 值加入到有序集 key 当中。
	 * @param key
	 * @param scoreMembers
	 * @return long
	 * @throws RedisException
	 */
	public long zadd(String key, Map<String, Double> scoreMembers) throws RedisException;

	/**
	 * 将多个member元素及其 score 值加入到有序集 key 当中。
	 * @param key
	 * @param scoreMembers
	 * @param params
	 * @return long
	 * @throws RedisException
	 */
	public long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) throws RedisException;

	/**
	 * 返回有序集key的基数
	 * @param key
	 * @return long
	 * @throws RedisException
	 */
	public long zcard(String key) throws RedisException;

	/**
	 * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
	 * @param key
	 * @param min
	 * @param max
	 * @return long
	 * @throws RedisException
	 */
	public long zcount(String key, double min, double max) throws RedisException;

	/**
	 * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
	 * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让 member 的 score 值减去 5
	 * @param key
	 * @param score
	 * @param member
	 * @return double member 成员的新 score 值，以字符串形式表示。
	 */
	public double zincrby(String key, double score, String member) throws RedisException;

	/**
	 * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
	 * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让 member 的 score 值减去 5
	 * @param key
	 * @param score
	 * @param member
	 * @return double member 成员的新 score 值，以字符串形式表示。
	 */
	public double zincrby(String key, double score, String member, ZIncrByParams params) throws RedisException;

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递增(从小到大)来排序。
	 * @param key
	 * @param start
	 * @param end
	 * @return Set<String>
	 * @throws RedisException
	 */
	public Set<String> zrange(String key, long start, long end) throws RedisException;

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递增(从小到大)来排序。成员和它的 score 值一并返回
	 * @param key
	 * @param start
	 * @param end
	 * @return Set<Tuple>
	 * @throws RedisException
	 */
	public Set<Tuple> zrangeWithScores(String key, long start, long end) throws RedisException;

	/**
	 * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
	 * @param String key reids键名
	 * @param double min 	最小分数值
	 * @param double max	最大分数值
	 * @return	Set<String>
	 */
	public Set<String> zrangeByScore(String key, double min, double max) throws RedisException;

	/**
	 * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
	 * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
	 * @param key
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return Set<String>
	 * @throws RedisException
	 */
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) throws RedisException;

	/**
	 * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。将有序集成员及其 score 值一起返回
	 * @param String key reids键名
	 * @param double min 	最小分数值
	 * @param double max	最大分数值
	 * @return	Set<String>
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) throws RedisException;

	/**
	 * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。将有序集成员及其 score 值一起返回
	 * @param String key reids键名
	 * @param double min 	最小分数值
	 * @param double max	最大分数值
	 * @return	Set<String>
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) throws RedisException;

	/**
	 * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。
	 * @param key
	 * @param member
	 * @return long
	 * @throws RedisException
	 */
	public long zrank(String key, String member) throws RedisException;

	/**
	 * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。
	 * 当 key 存在但不是有序集类型时，返回一个错误。
	 * @param key
	 * @param members
	 * @return long
	 * @throws RedisException
	 */
	public long zrem(String key, String... members) throws RedisException;

	/**
	 * 移除有序集 key 中，指定排名(rank)区间内的所有成员。
	 * @param key
	 * @param start
	 * @param end
	 * @return long
	 * @throws RedisException
	 */
	public long zremrangeByRank(String key, long start, long end) throws RedisException;

	/**
	 * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
	 * @param String key reids键名
	 * @param double min 	最小分数值
	 * @param double max	最大分数值
	 * @return long
	 */
	public long zremrangeByScore(String key, double min, double max) throws RedisException;

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递减(从大到小)来排列。
	 * @param key
	 * @param start
	 * @param end
	 * @return Set<String>
	 * @throws RedisException
	 */
	public Set<String> zrevrange(String key, long start, long end) throws RedisException;

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递减(从大到小)来排列。成员和它的 score 值一并返回
	 * @param key
	 * @param start
	 * @param end
	 * @return Set<Tuple>
	 * @throws RedisException
	 */
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) throws RedisException;

	/**
	 * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
	 * @param key
	 * @param max
	 * @param min
	 * @return Set<String>
	 * @throws RedisException
	 */
	public Set<String> zrevrangeByScore(String key, double max, double min) throws RedisException;

	/**
	 * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
	 * @param key
	 * @param max
	 * @param min
	 * @return Set<String>
	 * @throws RedisException
	 */
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) throws RedisException;

	/**
	 * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。成员及其 score 值一起返回
	 * @param key
	 * @param max
	 * @param min
	 * @return Set<Tuple>
	 * @throws RedisException
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) throws RedisException;

	/**
	 * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。成员及其 score 值一起返回
	 * @param key
	 * @param max
	 * @param min
	 * @return Set<Tuple>
	 * @throws RedisException
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) throws RedisException;

	/**
	 * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。
	 * @param key
	 * @param member
	 * @return long
	 * @throws RedisException
	 */
	public long zrevrank(String key, String member) throws RedisException;

	/**
	 * 返回有序集 key 中，成员 member 的 score 值。
	 * 如果 member 元素不是有序集 key 的成员，或 key 不存在，返回 nil 。
	 * @param key
	 * @param member
	 * @return double
	 * @throws RedisException
	 */
	public double zscore(String key, String member) throws RedisException;

	/**
	 * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination
	 * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
	 * @param dstkey
	 * @param sets
	 * @return long 保存到 destination 的结果集的基数。
	 * @throws RedisException
	 */
	public long zunionstore(String dstkey, String... sets) throws RedisException;

	/**
	 * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination
	 * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
	 * @param dstkey
	 * @param params
	 * @param sets
	 * @return long 保存到 destination 的结果集的基数。
	 * @throws RedisException
	 */
	public long zunionstore(String dstkey, ZParams params, String... sets) throws RedisException;

	/**
	 * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
	 * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
	 * @param dstkey
	 * @param sets
	 * @return long 保存到 destination 的结果集的基数。
	 * @throws RedisException
	 */
	public long zinterstore(String dstkey, String... sets) throws RedisException;

	/**
	 * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
	 * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
	 * @param dstkey
	 * @param params
	 * @param sets
	 * @return long 保存到 destination 的结果集的基数。
	 * @throws RedisException
	 */
	public long zinterstore(String dstkey, ZParams params, String... sets) throws RedisException;

	/**
	 * 用于迭代有序集合中的元素（包括元素成员和元素分值）。
	 * @param key
	 * @param cursor
	 * @return ScanResult<Tuple> 返回的每个元素都是一个有序集合元素，一个有序集合元素由一个成员（member）和一个分值（score）组成。
	 * @throws RedisException
	 */
	public ScanResult<Tuple> zscan(String key, String cursor) throws RedisException;

	/**
	 * 当有序集合的所有成员都具有相同的分值时， 有序集合的元素会根据成员的字典序（lexicographical ordering）来进行排序
	 * @param key
	 * @param min
	 * @param max
	 * @return Set<String> 一个列表，列表里面包含了有序集合在指定范围内的成员。
	 * @throws RedisException
	 */
	public Set<String> zrangeByLex(String key, String min, String max) throws RedisException;

	/**
	 * 当有序集合的所有成员都具有相同的分值时， 有序集合的元素会根据成员的字典序（lexicographical ordering）来进行排序
	 * 可选的 LIMIT offset count 参数用于获取指定范围内的匹配元素 （就像 SQL 中的 SELECT LIMIT offset count 语句）。
	 * @param key
	 * @param min
	 * @param max
	 * @return Set<String> 一个列表，列表里面包含了有序集合在指定范围内的成员。
	 * @throws RedisException
	 */
	public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) throws RedisException;

	/**
	 * 返回该集合中， 成员介于 min 和 max 范围内的元素数量。
	 * @param key
	 * @param min
	 * @param max
	 * @return long 指定范围内的元素数量。
	 * @throws RedisException
	 */
	public long zlexcount(String key, String min, String max) throws RedisException;

	/**
	 * 移除该集合中， 成员介于 min 和 max 范围内的所有元素。
	 * @param key
	 * @param min
	 * @param max
	 * @return long 被移除的元素数量。
	 * @throws RedisException
	 */
	public long zremrangeByLex(String key, String min, String max) throws RedisException;
	/************************** jredis SortedSet(有序集合) 命令工具方法 ****************************/

	/************************** HyperLogLog用来做基数统计的算法 ****************************/
	/**
	 * 将任意数量的元素添加到指定的 HyperLogLog 里面。
	 * @param key
	 * @param elements
	 * @return long  如果 HyperLogLog 的内部储存被修改了， 那么返回 1 ， 否则返回 0 。
	 * @throws RedisException
	 */
	public long pfadd(String key, String... elements) throws RedisException;

	/**
	 * 当 PFCOUNT 命令作用于单个键时， 返回储存在给定键的 HyperLogLog 的近似基数， 如果键不存在， 那么返回 0 。
	 * @param keys
	 * @return long
	 * @throws RedisException
	 */
	public long pfcount(String... keys) throws RedisException;

	/**
	 * 将多个 HyperLogLog 合并（merge）为一个 HyperLogLog ， 合并后的 HyperLogLog 的基数接近于所有输入 HyperLogLog 的可见集合（observed set）的并集。
	 * 合并得出的 HyperLogLog 会被储存在 destkey 键里面， 如果该键并不存在， 那么命令在执行之前， 会先为该键创建一个空的 HyperLogLog 。
	 * @param destkey
	 * @param sourcekeys
	 * @return String
	 * @throws RedisException
	 */
	public String pfmerge(String destkey, String... sourcekeys) throws RedisException;
	/************************** HyperLogLog用来做基数统计的算法 ****************************/

	// TODO GEO（地理位置）
	/************************** GEO（地理位置） ****************************/

	/**
	 * 将给定的空间元素（纬度、经度、名字）添加到指定的键里面
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param member
	 * @return long 新添加到键里面的空间元素数量， 不包括那些已经存在但是被更新的元素。
	 * @throws RedisException
	 */
	public long geoadd(String key, double longitude, double latitude, String member) throws RedisException;

	/**
	 * 将给定的空间元素（纬度、经度、名字）添加到指定的键里面
	 * @param key
	 * @param memberCoordinateMap
	 * @return long 新添加到键里面的空间元素数量， 不包括那些已经存在但是被更新的元素。
	 * @throws RedisException
	 */
	public long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) throws RedisException;

	/**
	 * 从键里面返回所有给定位置元素的位置（经度和纬度）
	 * @param key
	 * @param members
	 * @return List<GeoCoordinate> GEOPOS 命令返回一个数组， 数组中的每个项都由两个元素组成： 第一个元素为给定位置元素的经度， 而第二个元素则为给定位置元素的纬度。当给定的位置元素不存在时， 对应的数组项为空值。
	 * @throws RedisException
	 */
	public List<GeoCoordinate> geopos(String key, String... members) throws RedisException;

	/**
	 * 返回两个给定位置之间的距离。如果两个位置之间的其中一个不存在， 那么命令返回空值。
	 * 如果用户没有显式地指定单位参数， 那么 GEODIST 默认使用米作为单位。
	 * @param key
	 * @param member1
	 * @param member2
	 * @return double 计算出的距离会以双精度浮点数的形式被返回。 如果给定的位置元素不存在， 那么命令返回空值。
	 * @throws RedisException
	 */
	public double geodist(String key, String member1, String member2) throws RedisException;

	/**
	 * 返回两个给定位置之间的距离。如果两个位置之间的其中一个不存在， 那么命令返回空值。
	 * 指定单位的参数 unit 必须是以下单位的其中一个：m 表示单位为米。km 表示单位为千米。mi 表示单位为英里。ft 表示单位为英尺。
	 * @param key
	 * @param member1
	 * @param member2
	 * @param unit
	 * @return double 计算出的距离会以双精度浮点数的形式被返回。 如果给定的位置元素不存在， 那么命令返回空值。
	 * @throws RedisException
	 */
	public double geodist(String key, String member1, String member2, GeoUnit unit) throws RedisException;

	/**
	 * 以给定的经纬度为中心， 返回键包含的位置元素当中， 与中心的距离不超过给定最大距离的所有位置元素。
	 * 范围可以使用以下其中一个单位：m 表示单位为米。km 表示单位为千米。mi 表示单位为英里。ft 表示单位为英尺。
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param radius
	 * @param unit
	 * @return List<GeoRadiusResponse>
	 * @throws RedisException
	 */
	public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) throws RedisException;

	/**
	 * 以给定的经纬度为中心， 返回键包含的位置元素当中， 与中心的距离不超过给定最大距离的所有位置元素。
	 * 范围可以使用以下其中一个单位：m 表示单位为米。km 表示单位为千米。mi 表示单位为英里。ft 表示单位为英尺。
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param radius
	 * @param unit
	 * @param param
	 * @return List<GeoRadiusResponse
	 * @throws RedisException
	 */
	public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) throws RedisException;

	/**
	 * 这个命令和 GEORADIUS 命令一样， 都可以找出位于指定范围内的元素， 但是 GEORADIUSBYMEMBER 的中心点是由给定的位置元素决定的， 而不是像 GEORADIUS 那样， 使用输入的经度和纬度来决定中心点。
	 * @param key
	 * @param member
	 * @param radius
	 * @param unit
	 * @return List<GeoRadiusResponse>
	 * @throws RedisException
	 */
	public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) throws RedisException;

	/**
	 * 这个命令和 GEORADIUS 命令一样， 都可以找出位于指定范围内的元素， 但是 GEORADIUSBYMEMBER 的中心点是由给定的位置元素决定的， 而不是像 GEORADIUS 那样， 使用输入的经度和纬度来决定中心点。
	 * @param key
	 * @param member
	 * @param radius
	 * @param unit
	 * @param param
	 * @return List<GeoRadiusResponse>
	 * @throws RedisException
	 */
	public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) throws RedisException;

	/**
	 * 返回一个或多个位置元素的Geohash表
	 * @param key
	 * @param members
	 * @return List<String>
	 * @throws RedisException
	 */
	public List<String> geohash(String key, String... members) throws RedisException;
	/************************** GEO（地理位置） ****************************/

	// TODO Pub/Sub(发布/订阅) 命令工具方法
	/************************** jredis Pub/Sub(发布/订阅) 命令工具方法 ****************************/
	/**
	 * 订阅一个或多个符合给定模式的频道。
	 * 每个模式以 * 作为匹配符，比如 it* 匹配所有以 it 开头的频道( it.news 、 it.blog 、 it.tweets 等等)。 news.* 匹配所有以 news. 开头的频道( news.it 、 news.global.today 等等)，诸如此类。
	 * @param jedisPubSub
	 * @param patterns
	 */
	public void psubscribe(JedisPubSub jedisPubSub, String... patterns) throws RedisException;

	/**
	 * 用于将信息发送到指定的频道
	 * @param channel
	 * @param message
	 * @return long 接收到信息的订阅者数量
	 */
	public long publish(String channel, String message) throws RedisException;

	/**
	 * 订阅给定的一个或多个频道的信息
	 * @param jedisPubSub
	 * @param channels
	 * @throws RedisException
	 */
	public void subscribe(JedisPubSub jedisPubSub, String... channels) throws RedisException;
	/************************** jredis Pub/Sub（发布/订阅) 命令工具方法 ****************************/

	// TODO Transaction(事务) 命令工具方法
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/	/**
	 * 取消事务
	 * @return String
	 * @throws RedisException
	 */
	public String discard() throws RedisException;

	/**
	 * 执行所有事务块内的命令
	 * @return List<Object>
	 * @throws RedisException
	 */
	public List<Object> exec() throws RedisException;
	/**
	 * 标记一个事务块的开始
	 * 事务块内的多条命令会按照先后顺序被放进一个队列当中，最后由 EXEC 命令原子性(atomic)地执行。
	 * @return Transaction
	 * @throws RedisException
	 */
	public Transaction multi() throws RedisException;

	/**
	 * 监视一个(或多个) key
	 * 如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断
	 * @param keys
	 * @return String
	 * @throws RedisException
	 */
	public String watch(String... keys) throws RedisException;

	/**
	 * 取消 WATCH命令对所有 key的监视
	 * @return String
	 * @throws RedisException
	 */
	public String unwatch() throws RedisException;
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/

	// TODO Script(脚本) 命令工具方法
	/************************** jredis Script(脚本) 命令工具方法 ****************************/
	/************************** jredis Script(脚本) 命令工具方法 ****************************/

	// TODO Connection(连接) 命令工具方法
	/************************** jredis Connection(连接) 命令工具方法 ****************************/

	/**
	 * 用于检测给定的密码和配置文件中的密码是否相符
	 * @param password
	 * @return String 密码匹配时返回 OK ，否则返回一个错误
	 */
	public String auth(String password) throws RedisException;

	/**
	 * 用于打印给定的字符串
	 * @param string
	 * @return String 返回字符串本身
	 */
	public String echo(String string) throws RedisException;

	/**
	 * 使用客户端向 Redis 服务器发送一个 PING ，如果服务器运作正常的话，会返回一个 PONG 。通常用于测试与服务器的连接是否仍然生效，或者用于测量延迟值
	 * @return String 如果连接正常就返回一个 PONG ，否则返回一个连接错误
	 */
	public String ping() throws RedisException;

	/**
	 * 用于关闭与当前客户端与redis服务的连接。旦所有等待中的回复(如果有的话)顺利写入到客户端，连接就会被关闭。
	 * @return String 总是返回 OK
	 */
	public String quit() throws RedisException;

	/**
	 * 用于切换到指定的数据库，数据库索引号 index 用数字值指定，以 0 作为起始索引值
	 * @param index
	 * @return String 总是返回 OK
	 */
	public String select(int index) throws RedisException;
	/************************** jredis Connection(连接) 命令工具方法 ****************************/

	// TODO Server(服务器) 命令工具方法
	/************************** jredis Server(服务器) 命令工具方法 ****************************/
	/**
	 * 执行一个 AOF文件 重写操作。重写会创建一个当前 AOF 文件的体积优化版本
	 * 即使 BGREWRITEAOF 执行失败，也不会有任何数据丢失，因为旧的 AOF 文件在 BGREWRITEAOF 成功之前不会被修改。
	 * @return String
	 * @throws RedisException
	 */
	public String bgrewriteaof() throws RedisException;

	/**
	 * 在后台异步(Asynchronously)保存当前数据库的数据到磁盘
	 * @return String
	 * @throws RedisException
	 */
	public String bgsave() throws RedisException;

	/**
	 * 返回 CLIENT SETNAME 命令为连接设置的名字
	 * @return String
	 * @throws RedisException
	 */
	public String clientGetname() throws RedisException;

	/**
	 * 关闭地址为 ip:port 的客户端
	 * @return client
	 * @throws RedisException
	 */
	public String clientKill(String client) throws RedisException;

	/**
	 * 返回所有连接到服务器的客户端信息和统计数据
	 * @return String
	 * @throws RedisException
	 */
	public String clientList() throws RedisException;

	/**
	 * 为当前连接分配一个名字
	 * @return String
	 * @throws RedisException
	 */
	public String clientSetname(String name) throws RedisException;

	/**
	 * 返回当前数据库的key的数量
	 * @return long
	 * @throws RedisException
	 */
	public long dbSize() throws RedisException;

	/**
	 * 返回关于 Redis 服务器的各种信息和统计数
	 * @return String
	 * @throws RedisException
	 */
	public String info() throws RedisException;

	/**
	 * 执行一个同步保存操作
	 * 将当前 Redis 实例的所有数据快照(snapshot)以 RDB 文件的形式保存到硬
	 * @return String
	 * @throws RedisException
	 */
	public String save() throws RedisException;

	/**
	 * 停止所有客户端
	 * @return String
	 * @throws RedisException
	 */
	public String shutdown() throws RedisException;

	/**
	 * 动态地修改复制(replication)功能
	 * @param host
	 * @param port
	 * @return String
	 * @throws RedisException
	 */
	public String slaveof(String host, int port) throws RedisException;

	/**
	 * 复制功能(replication)的内部命令
	 * @throws RedisException
	 */
	public void sync() throws RedisException;

	/**
	 * 返回当前服务器时间
	 * @return List<String>
	 * @throws RedisException
	 */
	public List<String> time() throws RedisException;
	/************************** jredis Server(服务器) 命令工具方法 ****************************/
	/**
	 * 清空redis
	 */
	public void flush() throws RedisException;

	/**
	 * 关闭jedis
	 * @param jedis
	 */
	public void close(Jedis jedis) throws RedisException;

	/**
	 * 关闭Transaction
	 * @param transaction
	 */
	public void closeTransaction(Transaction transaction);

}