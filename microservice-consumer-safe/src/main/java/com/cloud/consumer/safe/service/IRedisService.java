package com.ochain.consumer.wheel.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRedisService {

	// TODO 键(key) 命令工具方法
	/************************** jredis 键(key) 命令工具方法 ****************************/
	/**
	 * 删除单个key
	 * @param key
	 * @return JSONObject
	 */
	public long del(String key);

	/**
	 * 删除多个key
	 * @param keys
	 * @return JSONObject
	 */
	public long delArray(String[] keys);

	/**
	 * 序列化给定key并返回被序列化的值
	 * @param key
	 * @return JSONObject
	 */
	public byte[] dump(String key);

	/**
	 * 检查key是否存在
	 * @param key
	 * @return JSONObject
	 */
	public boolean exists(String key);

	/**
	 * 检查key是否存在
	 * @param keys
	 * @return JSONObject
	 */
	public boolean existsArray(String[] keys);

	/**
	 * 设置单个key的过期时间
	 * @param key
	 * @param seconds
	 * @return JSONObject
	 */
	public long expire(String key,int seconds);

	/**
	 * 查找所有符合给定模式的key
	 * @param pattern
	 * @return JSONObject
	 */
	public Set<String> keys(String pattern);

	/**
	 * 将key原子性地从当前实例传送到目标实例的指定数据库
	 * @param key
	 * @param port
	 * @param destinationDb
	 * @return JSONObject
	 */
	public String migrate(String key,int port,int destinationDb,int timeout);

	/**
	 * 将当前数据库的key移动到给定的数据库db当中
	 * @param key
	 * @param dbIndex
	 * @return JSONObject
	 */
	public long move(String key,int dbIndex);

	/**
	 * 移除key的生存时间
	 * @param key
	 * @return JSONObject
	 */
	public long persist(String key);

	/**
	 * 设置 key的毫秒过期时间
	 * @param key
	 * @param milliseconds
	 * @return JSONObject
	 */
	public long pexpire(String key,long milliseconds);

	/**
	 * 毫秒为单位返回key的剩余生存时间
	 * @param key
	 * @return JSONObject
	 */
	public long pttl(String key);

	/**
	 * 当前数据库中随机返回一个key
	 * @return JSONObject
	 */
	public String randomKey();

	/**
	 * 修改key的名称
	 * @param oldkey
	 * @param newkey
	 * @return JSONObject
	 */
	public String rename(String oldkey,String newkey);

	/**
	 * 新key不存在时修改key的名称
	 * @param oldkey
	 * @param newkey
	 * @return JSONObject
	 */
	public long renamenx(String oldkey,String newkey);

	/**
	 * 反序列化给定的序列化值
	 * @param key
	 * @param ttl
	 * @param serializedValue
	 * @return JSONObject
	 */
	public long restore(String key,int ttl,Byte[] serializedValue);

	/**
	 * 反序列化给定的序列化值
	 * @param key
	 * @param ttl
	 * @param dstkey
	 * @return JSONObject
	 */
	public long sort(String key,String sortingParameters,String dstkey);

	/**
	 * 秒为单位返回 key的剩余生存时间
	 * @param key
	 * @return JSONObject
	 */
	public long ttl(String key);

	/**
	 * key储存的值的类型
	 * @param key
	 * @return JSONObject
	 */
	public String type(String key);
	/************************** jredis 键(key) 命令工具方法 ****************************/

	// TODO String(字符串) 命令工具方法
	/************************** jredis String(字符串) 命令工具方法 ****************************/
	/**
	 * 追加key值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long append(String key,String value);

	/**
	 * 计算给定字符串中被设置为1的比特位的数量
	 * @param key
	 * @return JSONObject
	 */
	public long bitcount(String key);

	/**
	 * 计算给定字符串中被设置为1的比特位的数量
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public long bitcountStartEnd(String key,long start,long end);

	/**
	 * 对一个保存二进制位的字符串key进行位元操作
	 * @param operation
	 * @param dstKey
	 * @param srcKey
	 * @return JSONObject
	 */
	public long bitop(String operation,String dstKey,String srcKey);

	/**
	 * 对多个保存二进制位的字符串key进行位元操作
	 * @param operation
	 * @param dstKey
	 * @param srcKey
	 * @return JSONObject
	 */
	public long bitopArray(String operation,String dstKey,String[] srcKeys);

	/**
	 * 将一个字符串看作是一个由二进制位组成的数组
	 * @param operation
	 * @param dstKey
	 * @param end
	 * @return JSONObject
	 */
	public List<Long> bitfield(String operation,String argument);

	/**
	 * 将多个字符串看作是一个由二进制位组成的数组
	 * @param operation
	 * @param dstKey
	 * @param end
	 * @return JSONObject
	 */
	public List<Long> bitfieldArray(String operation,String[] arguments);

	/**
	 * key中储存的数字值减一
	 * @param key
	 * @return JSONObject
	 */
	public long decr(String key);

	/**
	 * key所储存的值减去减量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long decrBy(String key,int value);

	/**
	 * 获取 key值
	 * @param key
	 * @return JSONObject
	 */
	public String get(String key);

	/**
	 * 对key所储存的字符串值，获取指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @return JSONObject
	 */
	public boolean getbit(String key,long offset);

	/**
	 * 获取存储在指定 key中字符串的子字符串
	 * @param key
	 * @param startOffset
	 * @param endOffset
	 * @return JSONObject
	 */
	public String getrange(String key,long startOffset,long endOffset);

	/**
	 * 指定key值返回key旧值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public String getSet(String key,String value);

	/**
	 * key中储存的数字值加一
	 * @param key
	 * @return JSONObject
	 */
	public long incr(String key);

	/**
	 * key所储存的值减去增量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long incrBy(String key,int value);

	/**
	 * key中所储存的值加上浮点数增量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public double incrByFloat(String key,double value);

	/**
	 * 返回一个key值
	 * @param key
	 * @return JSONObject
	 */
	public List<String> mget(String key);

	/**
	 * 返回多个key值
	 * @param keys
	 * @return JSONObject
	 */
	public List<String> mgetArray(String[] keys);

	/**
	 * 设置单个 key-value
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public String mset(String key,String value);

	/**
	 * 设置多个 key-value
	 * @param keysvalues
	 * @return JSONObject
	 */
	public String msetArray(String[] keysvalues);

	/**
	 * 设置单个 key-value
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public String msetnx(String key,String value);

	/**
	 * 设置多个 key-value
	 * @param keysvalues
	 * @return JSONObject
	 */
	public String msetnxArray(String[] keysvalues);

	/**
	 * 毫秒为单位设置key的生存时间
	 * @param key
	 * @param milliseconds
	 * @param value
	 * @return JSONObject
	 */
	public String psetex(String key,long milliseconds,String value);

	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public String set(String key,String value);

	/**
	 * 对key所储存的字符串值，设置或清除指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @param value
	 * @return JSONObject
	 */
	public boolean setbit(String key,long offset,String value);

	/**
	 * 设置key值和过期时间
	 * @param key
	 * @param seconds
	 * @param value
	 * @return JSONObject
	 */
	public String setex(String key,int seconds,String value);

	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long setnx(String key,String value);

	/**
	 * 指定的字符串覆盖给定key所储存的字符串值
	 * @param key
	 * @param offset
	 * @param value
	 * @return JSONObject
	 */
	public long setrange(String key,long offset,String value);

	/**
	 * 获取key所储存的字符串值的长度
	 * @param key
	 * @return JSONObject
	 */
	public long strlen(String key);
	/************************** jredis String(字符串) 命令工具方法 ****************************/

	// TODO Hash(哈希表) 命令工具方法
	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/
	/**
	 * 删除哈希表key中的一个字段
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	public long hdel(String key,String field);

	/**
	 * 删除哈希表key中的多个字段
	 * @param key
	 * @param fields
	 * @return JSONObject
	 */
	public long hdelArray(String key,String[] fields);

	/**
	 * 看哈希表的指定字段是否存在
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	public boolean hexists(String key,String field);

	/**
	 * 看哈希表中指定字段的值
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	public String hget(String key,String field);

	/**
	 * 返回哈希表中所有的字段和值
	 * @param key
	 * @return JSONObject
	 */
	public Map<String, String> hgetAll(String key) ;

	/**
	 * 哈希表中的字段值加上指定增量值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	public long hincrBy(String key,String field,int value);
	/**
	 * 哈希表中的字段值加上指定浮点数增量值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	public double hincrByFloat(String key,String field,double value);

	/**
	 * 获取哈希表中的所有字段名
	 * @param key
	 * @return JSONObject
	 */
	public Set<String> hkeys(String key);

	/**
	 * 获取哈希表中字段的数量
	 * @param key
	 * @return JSONObject
	 */
	public long hlen(String key);

	/**
	 * 返回哈希表中一个给定字段的值
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	public List<String> hmget(String key,String field);

	/**
	 * 返回哈希表中多个给定字段的值
	 * @param key
	 * @param fields
	 * @return JSONObject
	 */
	public List<String> hmgetArray(String key,String[] fields);

	/**
	 * 多个字段-值对设置到哈希表
	 * @param key
	 * @param hash
	 * @return JSONObject
	 */
	public String hmset(String key,Map<String, String> hash);

	/**
	 * 哈希表中的字段赋值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	public long hset(String key,String field,String value);

	/**
	 * 哈希表中的字段赋值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	public long hsetnx(String key,String field,String value);

	/**
	 * 返回哈希表所有字段的值
	 * @param key
	 * @return JSONObject
	 */
	public List<String> hvals(String key);

	/**
	 * 迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @return JSONObject
	 */
	public List<Map<String, String>> hscan(String key,String cursor);
	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/

	// TODO List(列表) 命令工具方法
	/************************** jredis List(列表) 命令工具方法 ****************************/
	/**
	 * 不超时移除并返回列表的第一个元素
	 * @param key
	 * @return JSONObject
	 */
	public String blpop(String key);

	/**
	 * 不超时移除并返回列表的第一个元素
	 * @param keys
	 * @return JSONObject
	 */
	public String blpopArray(String[] keys);

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param key
	 * @return JSONObject
	 */
	public String blpopTimeout(int timeout,String key);

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param keys
	 * @return JSONObject
	 */
	public String blpopTimeoutArray(int timeout,String[] keys);

	/**
	 * 阻塞移除并返回列表的第一个元素
	 * @param key
	 * @return JSONObject
	 */
	public String brpop(String key);

	/**
	 * 阻塞移除并返回列表的第一个元素
	 * @param keys
	 * @return JSONObject
	 */
	public String brpopArray(String[] keys);

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param key
	 * @return JSONObject
	 */
	public String brpopTimeout(int timeout,String key);

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param keys
	 * @return JSONObject
	 */
	public String brpopTimeoutArray(int timeout,String[] keys);

	/**
	 * 从列表中弹出一个值，将弹出的元素插入到另外一个列表
	 * @param source
	 * @param destination
	 * @param timeout
	 * @return JSONObject
	 */
	public String brpoplpush(String source,String destination,int timeout);

	/**
	 * 通过索引获取列表中的元素
	 * @param key
	 * @param index
	 * @return JSONObject
	 */
	public long lindex(String key,long index);

	/**
	 * 列表的元素前或者后插入元素
	 * @param key
	 * @param index
	 * @param where
	 * @param pivot
	 * @param value
	 * @return JSONObject
	 */
	public long linsert(String key,long index,String where,String pivot,String value);

	/**
	 * 返回列表的长度
	 * @param key
	 * @return JSONObject
	 */
	public long llen(String key);

	/**
	 * 移除并返回列表 key的头元素
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public String lpop(String key);

	/**
	 * 插入单个值到列表头部
	 * @param key
	 * @param value
	 * @return long
	 */
	public long lpush(String key,String value);

	/**
	 * 插入多个值到列表头部
	 * @param key
	 * @param values
	 * @return long
	 */
	public long lpushArray(String key,String[] values);

	/**
	 * 插入一个值到列表尾部
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long lpushx(String key,String value);

	/**
	 * 插入多个值到列表尾部
	 * @param key
	 * @param values
	 * @return long
	 */
	public long lpushxArray(String key,String[] values);

	/**
	 * 列表指定区间内的元素
	 * @param key
	 * @param from
	 * @param to
	 * @return JSONObject
	 */
	public List<String> lrange(String key,long from,long to);

	/**
	 * 移除列表中与参数value相等的元素
	 * @param key
	 * @param count
	 * @param value
	 * @return JSONObject
	 */
	public long lrem(String key,long count,String value);

	/**
	 * 通过索引来设置元素的值
	 * @param key
	 * @param index
	 * @param value
	 * @return JSONObject
	 */
	public String lset(String key,long index,String value);

	/**
	 * 列表进行修剪
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public String ltrim(String key,long start,long end);

	/**
	 * 移除并返回列表的最后一个元素
	 * @param key
	 * @return JSONObject
	 */
	public String rpop(String key);

	/**
	 * 列表中的最后一个元素(尾元素)弹出
	 * @param srckey
	 * @param dstkey
	 * @return JSONObject
	 */
	public String rpoplpush(String srckey,String dstkey);

	/**
	 * 插入一个值到列表尾部(最右边)
	 * @param key
	 * @param value
	 * @return long
	 */
	public long rpush(String key,String value);

	/**
	 * 插入多个值到列表尾部(最右边)
	 * @param key
	 * @param values
	 * @return long
	 */
	public long rpushArray(String key,String[] values);

	/**
	 * 插入一个或多个值到列表尾部
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	public long rpushx(String key,String value);

	/**
	 * 插入多个值到列表尾部
	 * @param key
	 * @param value
	 * @return long
	 */
	public long rpushxArray(String key,String[] values);
	/************************** jredis List(列表) 命令工具方法 ****************************/

	// TODO Set(集合) 命令工具方法
	/************************** jredis Set(集合) 命令工具方法 ****************************/
	/**
	 * 一个成员元素加入集合
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long sadd(String key,String member);

	/**
	 * 多个成员元素加入集合
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	public long saddArray(String key,String[] members);

	/**
	 * 返回集合元素数量
	 * @param key
	 * @return JSONObject
	 */
	public long scard(String key);

	/**
	 * 返回集合之间差集
	 * @param key
	 * @return JSONObject
	 */
	public Set<String> sdiff(String key);

	/**
	 * 返回集合之间差集
	 * @param keys
	 * @return JSONObject
	 */
	public Set<String> sdiffArray(String[] keys);

	/**
	 * 集合之间的差集存储在指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	public long sdiffstore(String dstkey,String key);

	/**
	 * 集合之间的差集存储在指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	public long sdiffstoreArray(String dstkey,String[] keys);

	/**
	 * 返回给定所有给定集合交集
	 * @param key
	 * @return JSONObject
	 */
	public Set<String> sinter(String key);

	/**
	 * 返回给定所有给定集合交集
	 * @param keys
	 * @return JSONObject
	 */
	public Set<String> sinterArray(String[] keys);

	/**
	 * 给定集合之间的交集存储在指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	public long sinterstore(String dstkey,String key);

	/**
	 * 给定集合之间的交集存储在指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	public long sinterstoreArray(String dstkey,String[] keys);

	/**
	 * 判断成员元素是否是集合的成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public boolean sismember(String key,String member);

	/**
	 * 返回集合中的所有的成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public List<String> smembers(String key);

	/**
	 * 成员移动
	 * @param srckey
	 * @param dstkey
	 * @param member
	 * @return JSONObject
	 */
	public long smove(String srckey,String dstkey,String member);

	/**
	 * 移除并返回集合中的一个随机元素
	 * @param key
	 * @return JSONObject
	 */
	public String spop(String key);

	/**
	 * 移除并返回集合中的一个随机元素
	 * @param key
	 * @param count
	 * @return JSONObject
	 */
	public Set<String> spopCount(String key,long count);

	/**
	 * 返回集合中的一个随机元素
	 * @param key
	 * @return JSONObject
	 */
	public String srandmember(String key);

	/**
	 * 返回集合中的一个随机元素
	 * @param key
	 * @param count
	 * @return JSONObject
	 */
	public List<String> srandmemberCount(String key,long count);

	/**
	 * 移除集合中的一个成员元素
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long srem(String key,String member);

	/**
	 * 移除集合中的一个成员元素
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	public long sremArray(String key,String[] members);

	/**
	 * 返回给定集合的并集
	 * @param key
	 * @return JSONObject
	 */
	public Set<String> sunion(String key);

	/**
	 * 返回给定集合的并集
	 * @param keys
	 * @return JSONObject
	 */
	public Set<String> sunionArray(String[] keys);

	/**
	 * 给定集合的并集存储指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	public long sunionstore(String dstkey,String key);

	/**
	 * 给定集合的并集存储指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	public long sunionstoreArray(String dstkey,String[] keys);

	/**
	 * 迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @return JSONObject
	 */
	public List<String> sscan(String key,String cursor);
	/************************** jredis Set(集合) 命令工具方法 ****************************/

	// TODO SortedSet(有序集合) 命令工具方法
	/************************** jredis SortedSet(有序集合) 命令工具方法 ****************************/
	/**
	 * 根据分数值存储有序集合
	 * @param key
	 * @param score
	 * @param member
	 * @return JSONObject
	 */
	public long zadd(String key,double score,String member);

	/**
	 * 有序集key的基数
	 * @param key
	 * @return long
	 */
	public long zcard(String key);

	/**
	 * 有序集key中成员的数量
	 * @param key
	 * @param min
	 * @param max
	 * @return long
	 */
	public long zcount(String key,String min,String max);

	/**
	 * 有序集合成员分数增加增量
	 * @param key
	 * @param score
	 * @param member
	 * @return JSONObject
	 */
	public double zincrby(String key,double score,String member);

	/**
	 * 有序集key中指定区间内的成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public List<String> zrange(String key,long start,long end);

	/**
	 * 有序集key中指定区间内从小到大的成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public List<Map<String, Object>> zrangeWithScores(String key,long start,long end) ;

	/**
	 * 根据分数值范围查询存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	public List<String> zrangeByScore(String key,double min,double max);

	/**
	 * 根据分数值范围查询存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	public List<Map<String, Object>> zrangeByScoreWithScores(String key,double min,double max);

	/**
	 * 有序集合成员分数增加增量
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long zrank(String key,String member);

	/**
	 * 移除有序集key中的一个成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long zrem(String key,String member);

	/**
	 * 移除有序集key中的多个成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long zremArray(String key,String[] members);

	/**
	 * 移除指定排名区间内的所有成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public long zremrangeByRank(String key,long start,long end);

	/**
	 * 分数值范围删除存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	public long zremrangeByScore(String key,double min,double max);

	/**
	 * 有序集key中指定区间内的从大到小成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public List<String> zrevrange(String key,long start,long end);

	/**
	 * 有序集key中指定区间内的从大到小成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	public List<Map<String, Object>> zrevrangeWithScores(String key,long start,long end);

	/**
	 * 有序集key中max和min之间所有的成员
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	public List<String> zrevrangeByScore(String key,double min,double max);

	/**
	 * 有序集key中max和min之间所有的成员
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	public List<Map<String, Object>> zrevrangeByScoreWithScores(String key,double min,double max);

	/**
	 * 有序集key中成员member从大到小的排名
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public long zrevrank(String key,String member);

	/**
	 * 有序集key中成员member的score值
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public double zscore(String key,String member);

	/************************** jredis SortedSet(有序集合) 命令工具方法 ****************************/

	/************************** jredis HyperLogLog（HyperLogLog) 命令工具方法 ****************************/
	/**
	 * 将一个数量的元素添加到指定的HyperLogLog里面
	 * @param key
	 * @param element
	 * @return JSONObject
	 */
	public long pfadd(String key,String element);

	/**
	 * 将多个数量的元素添加到指定的HyperLogLog里面
	 * @param key
	 * @param element
	 * @return JSONObject
	 */
	public long pfaddArray(String key,String[] elements);

	/**
	 * 返回储存在给定键的HyperLogLog的近似基数
	 * @param key
	 * @return JSONObject
	 */
	public long pfcount(String key);

	/**
	 * 返回储存在给定键的HyperLogLog的近似基数
	 * @param key
	 * @return JSONObject
	 */
	public long pfcountArray(String[] keys);

	/**
	 * 将一个HyperLogLog合并（merge）为一个HyperLogLog
	 * @param dstkey
	 * @param sourcekey
	 * @return JSONObject
	 */
	public String pfmerge(String dstkey,String sourcekey);

	/**
	 * 将多个HyperLogLog合并（merge）为一个HyperLogLog
	 * @param dstkey
	 * @param sourcekeys
	 * @return JSONObject
	 */
	public String pfmergeArray(String dstkey,String[] sourcekeys);


	/************************** jredis HyperLogLog（HyperLogLog) 命令工具方法 ****************************/

	// TODO GEO（地理位置）
	/************************** jredis GEO（地理位置） 命令工具方法 ****************************/
	/**
	 * 将给定的空间元素（纬度、经度、名字）添加到指定的键里面
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param member
	 * @return JSONObject
	 */
	public long geoadd(String key,long longitude,long latitude,String member);

	/**
	 * 将给定的空间元素（纬度、经度、名字）添加到指定的键里面
	 * @param <T>
	 * @param key
	 * @param memberCoordinateMap
	 * @return JSONObject
	 */
	public <T> long geoaddMap(String key,Map<String, T> memberCoordinateMap);

	/**
	 * 返回所有给定位置元素的位置（经度和纬度）
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public List<?> geopos(String key,String member);

	/**
	 * 返回两个给定位置之间的距离
	 * @param key
	 * @param member1
	 * @param member2
	 * @return JSONObject
	 */
	public double geodist(String key,String member1,String member2);

	/**
	 * 返回两个给定位置之间的距离
	 * @param key
	 * @param member1
	 * @param member2
	 * @param unit
	 * @return JSONObject
	 */
	public double geodistUnit(String key,String member1,String member2,String unit);

	/**
	 * 给定的经纬度为中心的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param unit
	 * @param radius
	 * @return JSONObject
	 */
	public List<?> georadius(String key,long longitude,long latitude,String unit,double radius);

	/**
	 * 给定的经纬度为中心的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param unit
	 * @param radius
	 * @param geoRadiusParam
	 * @param count
	 * @return JSONObject
	 */
	public List<?> georadiusParam(String key,long longitude,long latitude,String unit,double radius,String geoRadiusParam,long count);

	/**
	 * 以给定中心点的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param membere
	 * @param unit
	 * @param radius
	 * @return JSONObject
	 */
	public List<?> georadiusByMember(String key,String member,String unit,double radius);

	/**
	 * 给定的经纬度为中心的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param membere
	 * @param unit
	 * @param radius
	 * @param geoRadiusParam
	 * @param count
	 * @return JSONObject
	 */
	public List<?> georadiusByMemberParam(String key,String membere,String unit,double radius,String geoRadiusParam,long count);

	/**
	 * 返回一个位置元素的Geohash表
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	public List<String> geohash(String key,String member);

	/**
	 * 返回多个位置元素的Geohash表
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	public List<String> geohashArray(String key,String[] members);
	/************************** jredis GEO（地理位置） 命令工具方法 ****************************/

	// TODO Transaction(事务) 命令工具方法
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/
	/**
	 * 取消事务
	 * @return JSONObject
	 */
	public String discard();

	/**
	 * 执行所有事务
	 * @return JSONObject
	 */
	public List<Object> exec();

	/**
	 * 标记事务
	 * @return JSONObject
	 */
	public String multi();

	/**
	 * 取消WATCH命令对所有key的监视
	 * @return JSONObject
	 */
	public String unwatch(String key);

	/**
	 * 监视一个key
	 * @param key
	 * @return JSONObject
	 */
	public String watch(String key);

	/**
	 * 监视多个key
	 * @param keys
	 * @return JSONObject
	 */
	public String watchArray(String[] keys);
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/

}