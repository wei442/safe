package com.cloud.consumer.safe.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.BootConstants;
import com.cloud.common.constants.HttpUrlConstants;
import com.cloud.common.constants.RedisConstants;
import com.cloud.consumer.safe.service.IRedisService;

/**
 * redis Service (microservice-provider-redis)
 * @author wei.yong
 */
@Service
public class RedisServiceImpl extends BaseService implements IRedisService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	// TODO 键(key) 命令工具方法
	/************************** jredis 键(key) 命令工具方法 ****************************/
	/**
	 * 删除单个key
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long del(String key) {
		logger.info("(RedisService-del)-删除单个key-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/del", httpEntity, JSONObject.class);
		logger.info("(RedisService-del)-删除单个key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 删除多个key
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public long delArray(String[] keys) {
		logger.info("(RedisService-delArray)-删除多个key-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/array/del", httpEntity, JSONObject.class);
		logger.info("(RedisService-delArray)-删除多个key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 序列化给定key并返回被序列化的值
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public byte[] dump(String key) {
		logger.info("(RedisService-dump)-序列化给定key并返回被序列化的值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/dump", httpEntity, JSONObject.class);
		logger.info("(RedisService-dump)-序列化给定key并返回被序列化的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		byte[] result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBytes(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 检查key是否存在
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public boolean exists(String key) {
		logger.info("(RedisService-exists)-检查key是否存在-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/exists", httpEntity, JSONObject.class);
		logger.info("(RedisService-exists)-检查key是否存在-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 检查key是否存在
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public boolean existsArray(String[] keys) {
		logger.info("(RedisService-existsArray)-检查key是否存在-传入参数, key:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/array/exists", httpEntity, JSONObject.class);
		logger.info("(RedisService-existsArray)-检查key是否存在-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 设置单个key的过期时间
	 * @param key
	 * @param seconds
	 * @return JSONObject
	 */
	@Override
	public long expire(String key,int seconds) {
		logger.info("(RedisService-expire)-设置单个key的过期时间-传入参数, key:{}, seconds:{}", key, seconds);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("seconds", seconds);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/expire", httpEntity, JSONObject.class);
		logger.info("(RedisService-expire)-设置单个key的过期时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 查找所有符合给定模式的key
	 * @param pattern
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> keys(String pattern) {
		logger.info("(RedisService-keys)-查找所有符合给定模式的key-传入参数, pattern:{}", pattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pattern", pattern);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/keys", httpEntity, JSONObject.class);
		logger.info("(RedisService-keys)-查找所有符合给定模式的key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 将key原子性地从当前实例传送到目标实例的指定数据库
	 * @param key
	 * @param port
	 * @param destinationDb
	 * @return JSONObject
	 */
	@Override
	public String migrate(String key,int port,int destinationDb,int timeout) {
		logger.info("(RedisService-migrate)-将key原子性地从当前实例传送到目标实例的指定数据库-传入参数, key:{}, port:{}, destinationDb:{}, timeout:{}", key, port, destinationDb, timeout);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("port", port);
		params.put("destinationDb", destinationDb);
		params.put("timeout", timeout);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/migrate", httpEntity, JSONObject.class);
		logger.info("(RedisService-migrate)-将key原子性地从当前实例传送到目标实例的指定数据库-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 将当前数据库的key移动到给定的数据库db当中
	 * @param key
	 * @param dbIndex
	 * @return JSONObject
	 */
	@Override
	public long move(String key,int dbIndex) {
		logger.info("(RedisService-move)-将当前数据库的key移动到给定的数据库db当中-传入参数, key:{}, dbIndex:{}", key, dbIndex);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("dbIndex", dbIndex);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/move", httpEntity, JSONObject.class);
		logger.info("(RedisService-move)-将当前数据库的key移动到给定的数据库db当中-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除key的生存时间
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long persist(String key) {
		logger.info("(RedisService-keys)-移除key的生存时间-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/persist", httpEntity, JSONObject.class);
		logger.info("(RedisService-keys)-移除key的生存时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 设置 key的毫秒过期时间
	 * @param key
	 * @param milliseconds
	 * @return JSONObject
	 */
	@Override
	public long pexpire(String key,long milliseconds) {
		logger.info("(RedisService-pexpire)-设置 key的毫秒过期时间-传入参数, key:{}, milliseconds:{}", key, milliseconds);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("milliseconds", milliseconds);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/pexpire", httpEntity, JSONObject.class);
		logger.info("(RedisService-pexpire)-设置 key的毫秒过期时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 毫秒为单位返回key的剩余生存时间
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long pttl(String key) {
		logger.info("(RedisService-pttl)-毫秒为单位返回key的剩余生存时间-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/pttl", httpEntity, JSONObject.class);
		logger.info("(RedisService-pttl)-毫秒为单位返回key的剩余生存时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 当前数据库中随机返回一个key
	 * @return JSONObject
	 */
	@Override
	public String randomKey() {
		logger.info("(RedisService-keys)-当前数据库中随机返回一个key-传入参数为空");
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/randomKey", httpEntity, JSONObject.class);
		logger.info("(RedisService-keys)-当前数据库中随机返回一个key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 修改key的名称
	 * @param oldkey
	 * @param newkey
	 * @return JSONObject
	 */
	@Override
	public String rename(String oldkey,String newkey) {
		logger.info("(RedisService-rename)-修改key的名称-传入参数, oldkey:{}, milliseconds:{}", oldkey, newkey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oldkey", oldkey);
		params.put("newkey", newkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/rename", httpEntity, JSONObject.class);
		logger.info("(RedisService-rename)-修改key的名称-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
    }

	/**
	 * 新key不存在时修改key的名称
	 * @param oldkey
	 * @param newkey
	 * @return JSONObject
	 */
	@Override
	public long renamenx(String oldkey,String newkey) {
		logger.info("(RedisService-renamenx)-新key不存在时修改key的名称-传入参数, oldkey:{}, milliseconds:{}", oldkey, newkey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oldkey", oldkey);
		params.put("newkey", newkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/renamenx", httpEntity, JSONObject.class);
		logger.info("(RedisService-renamenx)-新key不存在时修改key的名称-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 反序列化给定的序列化值
	 * @param key
	 * @param ttl
	 * @param serializedValue
	 * @return JSONObject
	 */
	@Override
	public long restore(String key,int ttl,Byte[] serializedValue) {
		logger.info("(RedisService-restore)-反序列化给定的序列化值-传入参数, key:{}, ttl:{}, serializedValue:{}", key, ttl, serializedValue);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("ttl", ttl);
		params.put("serializedValue", serializedValue);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/restore", httpEntity, JSONObject.class);
		logger.info("(RedisService-restore)反序列化给定的序列化值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 反序列化给定的序列化值
	 * @param key
	 * @param ttl
	 * @param dstkey
	 * @return JSONObject
	 */
	@Override
	public long sort(String key,String sortingParameters,String dstkey) {
		logger.info("(RedisService-sort)-反序列化给定的序列化值-传入参数, key:{}, sortingParameters:{}, serializedValue:{}", key, sortingParameters, dstkey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("sortingParameters", sortingParameters);
		params.put("dstkey", dstkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/sort", httpEntity, JSONObject.class);
		logger.info("(RedisService-sort)反序列化给定的序列化值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 秒为单位返回 key的剩余生存时间
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long ttl(String key) {
		logger.info("(RedisService-ttl)-秒为单位返回 key的剩余生存时间-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/ttl", httpEntity, JSONObject.class);
		logger.info("(RedisService-ttl)-秒为单位返回 key的剩余生存时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * key储存的值的类型
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String type(String key) {
		logger.info("(RedisService-type)-key储存的值的类型-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/key/type", httpEntity, JSONObject.class);
		logger.info("(RedisService-ttl)-key储存的值的类型-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/************************** jredis 键(key) 命令工具方法 ****************************/

	// TODO String(字符串) 命令工具方法
	/************************** jredis String(字符串) 命令工具方法 ****************************/
	/**
	 * 追加key值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long append(String key,String value) {
		logger.info("(RedisService-append)-追加key值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/append", httpEntity, JSONObject.class);
		logger.info("(RedisService-append)-追加key值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 计算给定字符串中被设置为1的比特位的数量
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long bitcount(String key) {
		logger.info("(RedisService-bitcount)-计算给定字符串中被设置为1的比特位的数量-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/bitcount", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitcount)-计算给定字符串中被设置为1的比特位的数量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 计算给定字符串中被设置为1的比特位的数量
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@Override
	public long bitcountStartEnd(String key,long start,long end) {
		logger.info("(RedisService-bitcountStartEnd)-计算给定字符串中被设置为1的比特位的数量-传入参数, key:{}, start:{}, key:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/bitcountStartEnd", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitcountStartEnd)-计算给定字符串中被设置为1的比特位的数量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 对一个保存二进制位的字符串key进行位元操作
	 * @param operation
	 * @param dstKey
	 * @param end
	 * @return JSONObject
	 */
	@Override
	public long bitop(String operation,String dstKey,String srcKey) {
		logger.info("(RedisService-bitop)-对一个保存二进制位的字符串key进行位元操作-传入参数, operation:{}, dstKey:{}, srcKey:{}", operation, dstKey, srcKey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operation", operation);
		params.put("dstKey", dstKey);
		params.put("srcKey", srcKey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/bitop", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitop)-对一个保存二进制位的字符串key进行位元操作-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 对多个保存二进制位的字符串key进行位元操作
	 * @param operation
	 * @param dstKey
	 * @param srcKey
	 * @return JSONObject
	 */
	@Override
	public long bitopArray(String operation,String dstKey,String[] srcKeys) {
		logger.info("(RedisService-bitopArray)-对多个保存二进制位的字符串key进行位元操作-传入参数, operation:{}, dstKey:{}, srcKeys:{}", operation, dstKey, Arrays.toString(srcKeys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operation", operation);
		params.put("dstKey", dstKey);
		params.put("srcKeys", srcKeys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/array/bitop", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitopArray)-对多个保存二进制位的字符串key进行位元操作-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 将一个字符串看作是一个由二进制位组成的数组
	 * @param operation
	 * @param dstKey
	 * @param end
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Long> bitfield(String operation,String argument) {
		logger.info("(RedisService-bitfield)-将一个字符串看作是一个由二进制位组成的数组-传入参数, operation:{}, argument:{}", operation, argument);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operation", operation);
		params.put("argument", argument);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/bitfield", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitfield)-将一个字符串看作是一个由二进制位组成的数组-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Long> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Long>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 将多个字符串看作是一个由二进制位组成的数组
	 * @param operation
	 * @param dstKey
	 * @param end
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Long> bitfieldArray(String operation,String[] arguments) {
		logger.info("(RedisService-bitfieldArray)-将多个字符串看作是一个由二进制位组成的数组-传入参数, operation:{}, arguments:{}", operation, Arrays.toString(arguments));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operation", operation);
		params.put("arguments", arguments);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/array/bitfield", httpEntity, JSONObject.class);
		logger.info("(RedisService-bitfieldArray)-将多个字符串看作是一个由二进制位组成的数组-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Long> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Long>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * key中储存的数字值减一
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long decr(String key) {
		logger.info("(RedisService-decr)-key中储存的数字值减一-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/decr", httpEntity, JSONObject.class);
		logger.info("(RedisService-decr)-key中储存的数字值减一-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * key所储存的值减去减量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long decrBy(String key,int value) {
		logger.info("(RedisService-decrBy)-key所储存的值减去减量值-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/decrBy", httpEntity, JSONObject.class);
		logger.info("(RedisService-decrBy)-key所储存的值减去减量值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 获取 key值
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String get(String key) {
		logger.info("(RedisService-get)-获取 key值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/get", httpEntity, JSONObject.class);
		logger.info("(RedisService-get)-获取 key值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
    }

	/**
	 * 对key所储存的字符串值，获取指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @return JSONObject
	 */
	@Override
	public boolean getbit(String key,long offset) {
		logger.info("(RedisService-getbit)-对key所储存的字符串值，获取指定偏移量上的位(bit)-传入参数, key:{}, offset:{}", key, offset);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("offset", offset);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/getbit", httpEntity, JSONObject.class);
		logger.info("(RedisService-getbit)-对key所储存的字符串值，获取指定偏移量上的位(bit)-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 获取存储在指定 key中字符串的子字符串
	 * @param key
	 * @param startOffset
	 * @param endOffset
	 * @return JSONObject
	 */
	@Override
	public String getrange(String key,long startOffset,long endOffset) {
		logger.info("(RedisService-getrange)-获取存储在指定 key中字符串的子字符串-传入参数, key:{}, startOffset:{}, endOffset:{}", key, startOffset, endOffset);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("startOffset",startOffset);
		params.put("startOffset", startOffset);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/getrange", httpEntity, JSONObject.class);
		logger.info("(RedisService-getrange)-获取存储在指定 key中字符串的子字符串-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 指定key值返回key旧值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String getSet(String key,String value) {
		logger.info("(RedisService-getSet)-指定key值返回key旧值-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/getSet", httpEntity, JSONObject.class);
		logger.info("(RedisService-getSet)-指定key值返回key旧值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * key中储存的数字值加一
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long incr(String key) {
		logger.info("(RedisService-incr)-key中储存的数字值加一-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/incr", httpEntity, JSONObject.class);
		logger.info("(RedisService-incr)-key中储存的数字值加一-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * key所储存的值减去增量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long incrBy(String key,int value) {
		logger.info("(RedisService-incrBy)-key所储存的值减去增量值-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/incrBy", httpEntity, JSONObject.class);
		logger.info("(RedisService-incrBy)-key所储存的值减去增量值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * key中所储存的值加上浮点数增量值
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public double incrByFloat(String key,double value) {
		logger.info("(RedisService-incrByFloat)-key中所储存的值加上浮点数增量值-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/incrByFloat", httpEntity, JSONObject.class);
		logger.info("(RedisService-incrByFloat)-key中所储存的值加上浮点数增量值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDouble(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回一个key值
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> mget(String key) {
		logger.info("(RedisService-mget)-返回一个key值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/mget", httpEntity, JSONObject.class);
		logger.info("(RedisService-mget)-返回一个key值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 返回多个key值
	 * @param keys
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> mgetArray(String[] keys) {
		logger.info("(RedisService-mgetArray)-返回多个key值-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/array/mget", httpEntity, JSONObject.class);
		logger.info("(RedisService-mgetArray)-返回多个key值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 设置单个 key-value
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String mset(String key,String value) {
		logger.info("(RedisService-mset)-设置单个 key-value-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		String[] keysvalues = new String[]{key, value};
		params.put("keysvalues", keysvalues);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/mset", httpEntity, JSONObject.class);
		logger.info("(RedisService-mset)-设置单个 key-value-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 设置多个key-value
	 * @param keysvalues
	 * @return JSONObject
	 */
	@Override
	public String msetArray(String[] keysvalues) {
		logger.info("(RedisService-msetArray)-设置多个key-value-传入参数, keysvalues:{}", Arrays.toString(keysvalues));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keysvalues", keysvalues);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/mset", httpEntity, JSONObject.class);
		logger.info("(RedisService-msetArray)-设置多个key-value-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 设置单个 key-value
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String msetnx(String key,String value) {
		logger.info("(RedisService-msetnx)-设置单个 key-value-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		String[] keysvalues = new String[]{key, value};
		params.put("keysvalues", keysvalues);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/msetnx", httpEntity, JSONObject.class);
		logger.info("(RedisService-msetnx)-设置单个 key-value-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 设置多个 key-value
	 * @param keysvalues
	 * @return JSONObject
	 */
	@Override
	public String msetnxArray(String[] keysvalues) {
		logger.info("(RedisService-msetnx)-设置多个 key-value-传入参数, keysvalues:{}", Arrays.toString(keysvalues));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keysvalues", keysvalues);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/array/msetnx", httpEntity, JSONObject.class);
		logger.info("(RedisService-msetnx)-设置多个 key-value-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 毫秒为单位设置key的生存时间
	 * @param key
	 * @param milliseconds
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String psetex(String key,long milliseconds,String value) {
		logger.info("(RedisService-psetex)-毫秒为单位设置key的生存时间-传入参数, key:{}, milliseconds:{}, value:{}", key, milliseconds, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("milliseconds", milliseconds);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/psetex", httpEntity, JSONObject.class);
		logger.info("(RedisService-psetex)-毫秒为单位设置key的生存时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String set(String key,String value) {
		logger.info("(RedisService-set)-设置key-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/set", httpEntity, JSONObject.class);
		logger.info("(RedisService-set)-设置key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 对key所储存的字符串值，设置或清除指定偏移量上的位(bit)
	 * @param key
	 * @param offset
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public boolean setbit(String key,long offset,String value) {
		logger.info("(RedisService-setbit)-对key所储存的字符串值，设置或清除指定偏移量上的位(bit)-传入参数, key:{}, offset:{}, value:{}", key, offset, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("offset", offset);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/setbit", httpEntity, JSONObject.class);
		logger.info("(RedisService-setbit)-对key所储存的字符串值，设置或清除指定偏移量上的位(bit)-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 设置key值和过期时间
	 * @param key
	 * @param seconds
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String setex(String key,int seconds,String value) {
		logger.info("(RedisService-setex)-设置key值和过期时间-传入参数, key:{}, seconds:{}, value:{}", key, seconds, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("seconds", seconds);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/setex", httpEntity, JSONObject.class);
		logger.info("(RedisService-setex)-设置key值和过期时间-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long setnx(String key,String value) {
		logger.info("(RedisService-setnx)-设置key-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/setnx", httpEntity, JSONObject.class);
		logger.info("(RedisService-setnx)-设置key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 指定的字符串覆盖给定key所储存的字符串值
	 * @param key
	 * @param offset
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long setrange(String key,long offset,String value) {
		logger.info("(RedisService-setrange)-指定的字符串覆盖给定key所储存的字符串值-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("offset", offset);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/setrange", httpEntity, JSONObject.class);
		logger.info("(RedisService-setrange)-指定的字符串覆盖给定key所储存的字符串值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 获取key所储存的字符串值的长度
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long strlen(String key) {
		logger.info("(RedisService-strlen)-获取key所储存的字符串值的长度-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/string/strlen", httpEntity, JSONObject.class);
		logger.info("(RedisService-strlen)-获取key所储存的字符串值的长度-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }
	/************************** jredis String(字符串) 命令工具方法 ****************************/

	// TODO Hash(哈希表) 命令工具方法
	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/
	/**
	 * 删除哈希表key中的一个字段
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	@Override
	public long hdel(String key,String field) {
		logger.info("(RedisService-hdel)-删除哈希表key中的一个字段-传入参数, key:{}, field:{}", key, field);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hdel", httpEntity, JSONObject.class);
		logger.info("(RedisService-hdel)-删除哈希表key中的一个字段-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
    }

	/**
	 * 删除哈希表key中的多个字段
	 * @param key
	 * @param fields
	 * @return JSONObject
	 */
	@Override
	public long hdelArray(String key,String[] fields) {
		logger.info("(RedisService-hdelArray)-删除哈希表key中的多个字段-传入参数, key:{}, fields:{}", key, Arrays.toString(fields));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("fields", fields);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/array/hdel", httpEntity, JSONObject.class);
		logger.info("(RedisService-hdelArray)-删除哈希表key中的多个字段-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 看哈希表的指定字段是否存在
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	@Override
	public boolean hexists(String key,String field) {
		logger.info("(RedisService-hexists)-看哈希表的指定字段是否存在-传入参数, key:{}, field:{}", key, field);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hexists", httpEntity, JSONObject.class);
		logger.info("(RedisService-hexists)-看哈希表的指定字段是否存在-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 看哈希表中指定字段的值
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	@Override
	public String hget(String key,String field) {
		logger.info("(RedisService-hget)-哈希表中指定字段的值-传入参数, key:{}, field:{}", key, field);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hget", httpEntity, JSONObject.class);
		logger.info("(RedisService-hget)-哈希表中指定字段的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 返回哈希表中所有的字段和值
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> hgetAll(String key) {
		logger.info("(RedisService-hgetAll)-返回哈希表中所有的字段和值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hgetAll", httpEntity, JSONObject.class);
		logger.info("(RedisService-hget)-返回哈希表中所有的字段和值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Map<String, String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Map<String, String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 哈希表中的字段值加上指定增量值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long hincrBy(String key,String field,int value) {
		logger.info("(RedisService-hincrBy)-哈希表中的字段值加上指定增量值-传入参数, key:{}, field:{}, value:{}", key, field, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hincrBy", httpEntity, JSONObject.class);
		logger.info("(RedisService-hincrBy)-哈希表中的字段值加上指定增量值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 哈希表中的字段值加上指定浮点数增量值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public double hincrByFloat(String key,String field,double value) {
		logger.info("(RedisService-hincrByFloat)-哈希表中的字段值加上指定浮点数增量值-传入参数, key:{}, field:{}, value:{}", key, field, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hincrByFloat", httpEntity, JSONObject.class);
		logger.info("(RedisService-hincrByFloat)-哈希表中的字段值加上指定浮点数增量值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDoubleValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 获取哈希表中的所有字段名
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> hkeys(String key) {
		logger.info("(RedisService-hkeys)-获取哈希表中的所有字段名-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hkeys", httpEntity, JSONObject.class);
		logger.info("(RedisService-hkeys)-获取哈希表中的所有字段名-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 获取哈希表中字段的数量
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long hlen(String key) {
		logger.info("(RedisService-hlen)-获取哈希表中字段的数量-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hlen", httpEntity, JSONObject.class);
		logger.info("(RedisService-hlen)-获取哈希表中字段的数量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回哈希表中一个给定字段的值
	 * @param key
	 * @param field
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> hmget(String key,String field) {
		logger.info("(RedisService-hmget)-返回哈希表中一个给定字段的值-传入参数, key:{}, field:{}", key, field);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hmget", httpEntity, JSONObject.class);
		logger.info("(RedisService-hmget)-返回哈希表中一个给定字段的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回哈希表中多个给定字段的值
	 * @param key
	 * @param fields
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> hmgetArray(String key,String[] fields) {
		logger.info("(RedisService-hmget)-返回哈希表中多个给定字段的值-传入参数, key:{}, fields:{}", key, Arrays.toString(fields));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("fields", fields);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/array/hmget", httpEntity, JSONObject.class);
		logger.info("(RedisService-hmget)-返回哈希表中多个给定字段的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 多个字段-值对设置到哈希表
	 * @param key
	 * @param hash
	 * @return JSONObject
	 */
	@Override
	public String hmset(String key,Map<String, String> hash) {
		logger.info("(RedisService-hmset)-多个字段-值对设置到哈希表-传入参数, key:{}, hash:{}", key, hash);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("hash", hash);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hmset", httpEntity, JSONObject.class);
		logger.info("(RedisService-hmset)-多个字段-值对设置到哈希表-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 哈希表中的字段赋值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long hset(String key,String field,String value) {
		logger.info("(RedisService-hset)-哈希表中的字段赋值-传入参数, key:{}, field:{}, value:{}", key, field, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hset", httpEntity, JSONObject.class);
		logger.info("(RedisService-hset)-哈希表中的字段赋值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 哈希表中的字段赋值
	 * @param key
	 * @param field
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long hsetnx(String key,String field,String value) {
		logger.info("(RedisService-hsetnx)-哈希表中的字段赋值-传入参数, key:{}, field:{}, value:{}", key, field, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("field", field);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hsetnx", httpEntity, JSONObject.class);
		logger.info("(RedisService-hsetnx)-哈希表中的字段赋值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回哈希表所有字段的值
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> hvals(String key) {
		logger.info("(RedisService-hvals)-返回哈希表所有字段的值-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hvals", httpEntity, JSONObject.class);
		logger.info("(RedisService-hvals)-返回哈希表所有字段的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> hscan(String key,String cursor) {
		logger.info("(RedisService-hscan)-迭代集合键中的元素-传入参数, key:{}, cursor:{}", key, cursor);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("cursor", cursor);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hash/hscan", httpEntity, JSONObject.class);
		logger.info("(RedisService-hscan)-迭代集合键中的元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Map<String, String>> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Map<String, String>>) response.get(RedisConstants.RESULT);
		}
		return result;
	}
	/************************** jredis Hash(哈希表) 命令工具方法 ****************************/

	// TODO List(列表) 命令工具方法
	/************************** jredis List(列表) 命令工具方法 ****************************/
	/**
	 * 不超时移除并返回列表的第一个元素
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String blpop(String key) {
		logger.info("(RedisService-blpop)-不超时移除并返回列表的第一个元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/blpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-blpop)-不超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 不超时移除并返回列表的第一个元素
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public String blpopArray(String[] keys) {
		logger.info("(RedisService-blpopArray)-不超时移除并返回列表的第一个元素-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/blpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-blpopArray)-不超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String blpopTimeout(int timeout,String key) {
		logger.info("(RedisService-blpopTimeout)-超时移除并返回列表的第一个元素-传入参数, timeout:{}, key:{}", timeout, key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeout", timeout);
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/timeout/blpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-blpopTimeout)-超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public String blpopTimeoutArray(int timeout,String[] keys) {
		logger.info("(RedisService-blpopTimeoutArray)-超时移除并返回列表的第一个元素-传入参数, timeout:{}, keys:{}", timeout, Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeout", timeout);
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/timeout/array/blpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-blpopTimeoutArray)-超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 阻塞移除并返回列表的第一个元素
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String brpop(String key) {
		logger.info("(RedisService-brpop)-阻塞移除并返回列表的第一个元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/brpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-brpop)-阻塞移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 阻塞移除并返回列表的第一个元素
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public String brpopArray(String[] keys) {
		logger.info("(RedisService-brpopArray)-阻塞移除并返回列表的第一个元素-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/brpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-brpopArray)-阻塞移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String brpopTimeout(int timeout,String key) {
		logger.info("(RedisService-brpopTimeout)-超时移除并返回列表的第一个元素-传入参数, timeout:{}, key:{}", timeout, key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeout", timeout);
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/timeout/brpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-brpopTimeout)-超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 超时移除并返回列表的第一个元素
	 * @param timeout
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public String brpopTimeoutArray(int timeout,String[] keys) {
		logger.info("(RedisService-brpopTimeoutArray)-超时移除并返回列表的第一个元素-传入参数, timeout:{}, keys:{}", timeout, Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeout", timeout);
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/timeout/array/brpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-brpopTimeoutArray)-超时移除并返回列表的第一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 从列表中弹出一个值，将弹出的元素插入到另外一个列表
	 * @param source
	 * @param destination
	 * @param timeout
	 * @return JSONObject
	 */
	@Override
	public String brpoplpush(String source,String destination,int timeout) {
		logger.info("(RedisService-brpoplpush)-从列表中弹出一个值，将弹出的元素插入到另外一个列表-传入参数, source:{}, destination:{}, timeout:{}", source, destination, timeout);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", source);
		params.put("destination", destination);
		params.put("timeout", timeout);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/brpoplpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-brpoplpush)-从列表中弹出一个值，将弹出的元素插入到另外一个列表-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 通过索引获取列表中的元素
	 * @param key
	 * @param index
	 * @return JSONObject
	 */
	@Override
	public long lindex(String key,long index) {
		logger.info("(RedisService-lindex)-通过索引获取列表中的元素-传入参数, key:{}, index:{}", key, index);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("index", index);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lindex", httpEntity, JSONObject.class);
		logger.info("(RedisService-lindex)-通过索引获取列表中的元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 列表的元素前或者后插入元素
	 * @param key
	 * @param index
	 * @param where
	 * @param pivot
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long linsert(String key,long index,String where,String pivot,String value) {
		logger.info("(RedisService-linsert)-列表的元素前或者后插入元素-传入参数, key:{}, index:{}, where:{}, pivot:{}, value:{}", key, index, where, pivot, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("index", index);
		params.put("where", where);
		params.put("pivot", pivot);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/linsert", httpEntity, JSONObject.class);
		logger.info("(RedisService-linsert)-列表的元素前或者后插入元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}


	/**
	 * 返回列表的长度
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long llen(String key) {
		logger.info("(RedisService-llen)-返回列表的长度-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/llen", httpEntity, JSONObject.class);
		logger.info("(RedisService-llen)-返回列表的长度-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除并返回列表 key的头元素
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String lpop(String key) {
		logger.info("(RedisService-lpop)-移除并返回列表 key的头元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-lpop)-移除并返回列表 key的头元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 插入单个值到列表头部
	 * @param key
	 * @param value
	 * @return long
	 */
	@Override
	public long lpush(String key,String value) {
		logger.info("(RedisService-lpush)-插入单个值到列表头部-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-lpush)-插入单个值到列表头部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入多个值到列表头部
	 * @param key
	 * @param values
	 * @return long
	 */
	@Override
	public long lpushArray(String key,String[] values) {
		logger.info("(RedisService-lpushArray)-插入多个值到列表头部-传入参数, key:{}, values:{}", key, Arrays.toString(values));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("values", values);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/lpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-lpushArray)-插入多个值到列表头部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入一个值到列表尾部
	 * @param key
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long lpushx(String key,String value) {
		logger.info("(RedisService-lpushx)-插入一个值到列表尾部-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lpushx", httpEntity, JSONObject.class);
		logger.info("(RedisService-lpushx)-插入一个值到列表尾部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入多个值到列表尾部
	 * @param key
	 * @param values
	 * @return long
	 */
	@Override
	public long lpushxArray(String key,String[] values) {
		logger.info("(RedisService-lpushxArray)-入多个值到列表尾部-传入参数, key:{}, values:{}", key, Arrays.toString(values));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("values", values);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/lpushx", httpEntity, JSONObject.class);
		logger.info("(RedisService-lpushxArray)-入多个值到列表尾部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 列表指定区间内的元素
	 * @param key
	 * @param from
	 * @param to
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> lrange(String key,long from,long to) {
		logger.info("(RedisService-lrange)-列表指定区间内的元素-传入参数, key:{}, from:{}, to:{}", key, from, to);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("from", from);
		params.put("to", to);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lrange", httpEntity, JSONObject.class);
		logger.info("(RedisService-lrange)-列表指定区间内的元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除列表中与参数value相等的元素
	 * @param key
	 * @param count
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public long lrem(String key,long count,String value) {
		logger.info("(RedisService-lrem)-移除列表中与参数value相等的元素-传入参数, key:{}, count:{}, value:{}", key, count, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("count", count);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lrem", httpEntity, JSONObject.class);
		logger.info("(RedisService-lrem)-移除列表中与参数value相等的元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 通过索引来设置元素的值
	 * @param key
	 * @param index
	 * @param value
	 * @return JSONObject
	 */
	@Override
	public String lset(String key,long index,String value) {
		logger.info("(RedisService-lset)-通过索引来设置元素的值-传入参数, key:{}, index:{}, value:{}", key, index, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("index", index);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/lset", httpEntity, JSONObject.class);
		logger.info("(RedisService-lset)-通过索引来设置元素的值-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 列表进行修剪
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@Override
	public String ltrim(String key,long start,long end) {
		logger.info("(RedisService-ltrim)-列表进行修剪-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/ltrim", httpEntity, JSONObject.class);
		logger.info("(RedisService-ltrim)-列表进行修剪-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 移除并返回列表的最后一个元素
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String rpop(String key) {
		logger.info("(RedisService-rpop)-移除并返回列表的最后一个元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/rpop", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpop)-移除并返回列表的最后一个元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 列表中的最后一个元素(尾元素)弹出
	 * @param srckey
	 * @param dstkey
	 * @return JSONObject
	 */
	@Override
	public String rpoplpush(String srckey,String dstkey) {
		logger.info("(RedisService-rpoplpush)-列表中的最后一个元素(尾元素)弹出-传入参数, srckey:{}, dstkey:{}", srckey, dstkey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("srckey", srckey);
		params.put("dstkey", dstkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/rpoplpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpoplpush)-列表中的最后一个元素(尾元素)弹出-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 插入一个值到列表尾部(最右边)
	 * @param key
	 * @param value
	 * @return long
	 */
	@Override
	public long rpush(String key,String value) {
		logger.info("(RedisService-rpush)-插入一个值到列表尾部(最右边)-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/rpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpush)-插入一个值到列表尾部(最右边)-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入多个值到列表尾部(最右边)
	 * @param key
	 * @param values
	 * @return long
	 */
	@Override
	public long rpushArray(String key,String[] values) {
		logger.info("(RedisService-rpushArray)-插入多个值到列表尾部(最右边)-传入参数, key:{}, values:{}", key, Arrays.toString(values));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("values", values);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/rpush", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpushArray)-插入多个值到列表尾部(最右边)-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入一个值到列表尾部
	 * @param key
	 * @param value
	 * @return long
	 */
	@Override
	public long rpushx(String key,String value) {
		logger.info("(RedisService-rpushx)-插入一个值到列表尾部-传入参数, key:{}, value:{}", key, value);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("value", value);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/rpushx", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpushx)-插入一个值到列表尾部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 插入多个值到列表尾部
	 * @param key
	 * @param value
	 * @return long
	 */
	@Override
	public long rpushxArray(String key,String[] values) {
		logger.info("(RedisService-rpushxArray)-插入多个个值到列表尾部-传入参数, key:{}, values:{}", key, Arrays.toString(values));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("values", values);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/list/array/rpushx", httpEntity, JSONObject.class);
		logger.info("(RedisService-rpushxArray)-插入多个值到列表尾部-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}
	/************************** jredis List(列表) 命令工具方法 ****************************/

	// TODO Set(集合) 命令工具方法
	/************************** jredis Set(集合) 命令工具方法 ****************************/
	/**
	 * 一个成员元素加入集合
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long sadd(String key,String member) {
		logger.info("(RedisService-sadd)-一个成员元素加入集合-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-sadd)-一个成员元素加入集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 多个成员元素加入集合
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	@Override
	public long saddArray(String key,String[] members) {
		logger.info("(RedisService-saddArray)-多个成员元素加入集合-传入参数, key:{}, members:{}", key, Arrays.toString(members));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("members", members);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-saddArray)-多个成员元素加入集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回集合元素数量
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long scard(String key) {
		logger.info("(RedisService-scard)-返回集合元素数量-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/scard", httpEntity, JSONObject.class);
		logger.info("(RedisService-scard)-返回集合元素数量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回集合之间差集
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sdiff(String key) {
		logger.info("(RedisService-sdiff)-返回集合之间差集-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sdiff", httpEntity, JSONObject.class);
		logger.info("(RedisService-sdiff)-返回集合之间差集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回集合之间差集
	 * @param keys
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sdiffArray(String[] keys) {
		logger.info("(RedisService-sdiffArray)-返回集合之间差集-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sdiff", httpEntity, JSONObject.class);
		logger.info("(RedisService-sdiffArray)-返回集合之间差集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 集合之间的差集存储在指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long sdiffstore(String dstkey,String key) {
		logger.info("(RedisService-sdiffstore)-集合之间的差集存储在指定的集合-传入参数, dstkey:{}, key:{}", dstkey, key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("dstkey", dstkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sdiffstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sdiffstore)-集合之间的差集存储在指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 集合之间的差集存储在指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public long sdiffstoreArray(String dstkey,String[] keys) {
		logger.info("(RedisService-sdiffstoreArray)-集合之间的差集存储在指定的集合-传入参数, dstkey:{}, keys:{}", dstkey, Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		params.put("dstkey", dstkey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sdiffstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sdiffstoreArray)-集合之间的差集存储在指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回给定所有给定集合交集
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sinter(String key) {
		logger.info("(RedisService-sinter)-返回给定所有给定集合交集-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sinter", httpEntity, JSONObject.class);
		logger.info("(RedisService-sinter)-返返回给定所有给定集合交集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回给定所有给定集合交集
	 * @param keys
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sinterArray(String[] keys) {
		logger.info("(RedisService-sinterArray)-返回给定所有给定集合交集-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sinter", httpEntity, JSONObject.class);
		logger.info("(RedisService-sinterArray)-返返回给定所有给定集合交集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 给定集合之间的交集存储在指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long sinterstore(String dstkey,String key) {
		logger.info("(RedisService-sinterstore)-给定集合之间的交集存储在指定的集合-传入参数, dstkey:{}, key:{}", dstkey, key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sinterstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sinterstore)-给定集合之间的交集存储在指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 给定集合之间的交集存储在指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public long sinterstoreArray(String dstkey,String[] keys) {
		logger.info("(RedisService-sinterstoreArray)-给定集合之间的交集存储在指定的集合-传入参数, dstkey:{}, keys:{}", dstkey, Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sinterstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sinterstoreArray)-给定集合之间的交集存储在指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 判断成员元素是否是集合的成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public boolean sismember(String key,String member) {
		logger.info("(RedisService-sismember)-判断成员元素是否是集合的成员-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sismember", httpEntity, JSONObject.class);
		logger.info("(RedisService-sismember)-判断成员元素是否是集合的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		boolean result = false;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getBooleanValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回集合中的所有的成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> smembers(String key) {
		logger.info("(RedisService-smembers)-返回集合中的所有的成员-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/smembers", httpEntity, JSONObject.class);
		logger.info("(RedisService-smembers)-返回集合中的所有的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 成员移动
	 * @param srckey
	 * @param dstkey
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long smove(String srckey,String dstkey,String member) {
		logger.info("(RedisService-smove)-成员移动-传入参数, srckey:{}, dstkey:{}, member:{}", srckey, dstkey, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("srckey", srckey);
		params.put("dstkey", dstkey);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/smove", httpEntity, JSONObject.class);
		logger.info("(RedisService-smove)-成员移动-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除并返回集合中的一个随机元素
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String spop(String key) {
		logger.info("(RedisService-spop)-移除并返回集合中的一个随机元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/spop", httpEntity, JSONObject.class);
		logger.info("(RedisService-spop)-移除并返回集合中的一个随机元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 移除并返回集合中的一个随机元素
	 * @param key
	 * @param count
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Set<String> spopCount(String key,long count) {
		logger.info("(RedisService-spopCount)-移除并返回集合中的一个随机元素-传入参数, key:{}, count:{}", key, count);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("count", count);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/count/spop", httpEntity, JSONObject.class);
		logger.info("(RedisService-spopCount)-移除并返回集合中的一个随机元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回集合中的一个随机元素
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String srandmember(String key) {
		logger.info("(RedisService-srandmember)-返回集合中的一个随机元素-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/srandmember", httpEntity, JSONObject.class);
		logger.info("(RedisService-srandmember)-返回集合中的一个随机元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 返回集合中的一个随机元素
	 * @param key
	 * @param count
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> srandmemberCount(String key,long count) {
		logger.info("(RedisService-srandmember)-返回集合中的一个随机元素-传入参数, key:{}, count:{}", key, count);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("count", count);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/count/srandmember", httpEntity, JSONObject.class);
		logger.info("(RedisService-srandmember)-返回集合中的一个随机元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除集合中的一个成员元素
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long srem(String key,String member) {
		logger.info("(RedisService-srem)-移除集合中的一个成员元素-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/srem", httpEntity, JSONObject.class);
		logger.info("(RedisService-srem)-移除集合中的一个成员元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除集合中的一个成员元素
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	@Override
	public long sremArray(String key,String[] members) {
		logger.info("(RedisService-sremArray)-移除集合中的一个成员元素-传入参数, key:{}, members:{}", key, Arrays.toString(members));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("members", members);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/srem", httpEntity, JSONObject.class);
		logger.info("(RedisService-sremArray)-移除集合中的一个成员元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回给定集合的并集
	 * @param key
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sunion(String key) {
		logger.info("(RedisService-sunion)-返回给定集合的并集-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sunion", httpEntity, JSONObject.class);
		logger.info("(RedisService-sunion)-返回给定集合的并集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回给定集合的并集
	 * @param keys
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> sunionArray(String[] keys) {
		logger.info("(RedisService-sunionArray)-返回给定集合的并集-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sunion", httpEntity, JSONObject.class);
		logger.info("(RedisService-sunionArray)-返回给定集合的并集-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		Set<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (Set<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 给定集合的并集存储指定的集合
	 * @param dstkey
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long sunionstore(String dstkey,String key) {
		logger.info("(RedisService-sunionstore)-给定集合的并集存储指定的集合-传入参数, dstkey:{}, key:{}", dstkey, key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sunionstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sunionstore)-给定集合的并集存储指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 给定集合的并集存储指定的集合
	 * @param dstkey
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public long sunionstoreArray(String dstkey,String[] keys) {
		logger.info("(RedisService-sunionstore)-给定集合的并集存储指定的集合-传入参数, dstkey:{}, keys:{}", dstkey, Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/array/sunionstore", httpEntity, JSONObject.class);
		logger.info("(RedisService-sunionstore)-给定集合的并集存储指定的集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 迭代集合键中的元素
	 * @param key
	 * @param cursor
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> sscan(String key,String cursor) {
		logger.info("(RedisService-sscan)-迭代集合键中的元素-传入参数, key:{}, cursor:{}", key, cursor);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("cursor", cursor);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/set/sscan", httpEntity, JSONObject.class);
		logger.info("(RedisService-sscan)-迭代集合键中的元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}
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
	@Override
	public long zadd(String key,double score,String member) {
		logger.info("(RedisService-zadd)-根据分数值存储有序集合-传入参数, key:{}, score:{}, member:{}", key, score, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("score", score);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-zadd)-根据分数值存储有序集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key的基数
	 * @param key
	 * @return long
	 */
	@Override
	public long zcard(String key) {
		logger.info("(RedisService-zcard)-有序集key的基数-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zcard", httpEntity, JSONObject.class);
		logger.info("(RedisService-zcard)-有序集key的基数-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中成员的数量
	 * @param key
	 * @param min
	 * @param max
	 * @return long
	 */
	@Override
	public long zcount(String key,String min,String max) {
		logger.info("(RedisService-zcount)-有序集key中成员的数量-传入参数, key:{}, min:{}, member:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("minStr", min);
		params.put("maxStr", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zcount", httpEntity, JSONObject.class);
		logger.info("(RedisService-zcount)-有序集key中成员的数量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集合成员分数增加增量
	 * @param key
	 * @param score
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public double zincrby(String key,double score,String member) {
		logger.info("(RedisService-zincrby)-有序集合成员分数增加增量-传入参数, key:{}, score:{}, member:{}", key, score, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("score", score);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zincrby", httpEntity, JSONObject.class);
		logger.info("(RedisService-zincrby)-有序集合成员分数增加增量-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDoubleValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中指定区间内从小到大的成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> zrange(String key,long start,long end) {
		logger.info("(RedisService-zrange)-有序集key中指定区间内从小到大的成员-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrange", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrange)-有序集key中指定区间内从小到大的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中指定区间内从小到大的成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> zrangeWithScores(String key,long start,long end) {
		logger.info("(RedisService-zrange)-有序集key中指定区间内从小到大的成员-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrangeWithScores", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrange)-有序集key中指定区间内从小到大的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Object> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Object>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 根据分数值范围查询存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> zrangeByScore(String key,double min,double max) {
		logger.info("(RedisService-zrangeByScore)-根据分数值范围查询存储有序集合-传入参数, key:{}, min:{}, max:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("min", min);
		params.put("max", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrangeByScore", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrangeByScore)-根据分数值范围查询存储有序集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 根据分数值范围查询存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> zrangeByScoreWithScores(String key,double min,double max) {
		logger.info("(RedisService-zrangeByScoreWithScores)-根据分数值范围查询存储有序集合-传入参数, key:{}, min:{}, max:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("min", min);
		params.put("max", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrangeByScoreWithScores", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrangeByScoreWithScores)-根据分数值范围查询存储有序集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Object> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Object>) response.get(RedisConstants.RESULT);
		}
		return result;
	}


	/**
	 * 有序集key中成员member从小到大的排名
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long zrank(String key,String member) {
		logger.info("(RedisService-zrank)-有序集key中成员member从小到大的排名-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrank", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrank)-有序集key中成员member从小到大的排名-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除有序集key中的一个成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long zrem(String key,String member) {
		logger.info("(RedisService-zrem)-移除有序集key中的一个成员-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrem", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrem)-移除有序集key中的一个成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除有序集key中的多个成员
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long zremArray(String key,String[] members) {
		logger.info("(RedisService-zremArray)-移除有序集key中的多个成员-传入参数, key:{}, members:{}", key, Arrays.toString(members));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("members", members);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/array/zrem", httpEntity, JSONObject.class);
		logger.info("(RedisService-zremArray)-移除有序集key中的多个成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 移除指定排名区间内的所有成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@Override
	public long zremrangeByRank(String key,long start,long end) {
		logger.info("(RedisService-zremrangeByRank)-移除指定排名区间内的所有成员-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zremrangeByRank", httpEntity, JSONObject.class);
		logger.info("(RedisService-zremrangeByRank)-移除指定排名区间内的所有成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 分数值范围删除存储有序集合
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	@Override
	public long zremrangeByScore(String key,double min,double max) {
		logger.info("(RedisService-zremrangeByScore)-分数值范围删除存储有序集合-传入参数, key:{}, min:{}, max:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("min", min);
		params.put("max", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zremrangeByScore", httpEntity, JSONObject.class);
		logger.info("(RedisService-zremrangeByScore)-分数值范围删除存储有序集合-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中指定区间内的从大到小成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> zrevrange(String key,long start,long end) {
		logger.info("(RedisService-zrevrange)-有序集key中指定区间内的从大到小成员-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrevrange", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrevrange)-有序集key中指定区间内的从大到小成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中指定区间内的从大到小成员
	 * @param key
	 * @param start
	 * @param end
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> zrevrangeWithScores(String key,long start,long end) {
		logger.info("(RedisService-zrevrange)-有序集key中指定区间内的从大到小成员-传入参数, key:{}, start:{}, end:{}", key, start, end);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("start", start);
		params.put("end", end);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrevrangeWithScores", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrevrange)-有序集key中指定区间内的从大到小成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Object> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Object>) response.get(RedisConstants.RESULT);
		}
		return result;
	}


	/**
	 * 有序集key中max和min之间所有的成员
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> zrevrangeByScore(String key,double min,double max) {
		logger.info("(RedisService-zrevrange)-有序集key中max和min之间所有的成员-传入参数, key:{}, min:{}, max:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("min", min);
		params.put("max", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrevrangeByScore", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrevrange)-有序集key中max和min之间所有的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中max和min之间所有的成员
	 * @param key
	 * @param min
	 * @param max
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> zrevrangeByScoreWithScores(String key,double min,double max) {
		logger.info("(RedisService-zrevrangeByScoreWithScores)-有序集key中max和min之间所有的成员-传入参数, key:{}, min:{}, max:{}", key, min, max);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("min", min);
		params.put("max", max);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrevrangeByScoreWithScores", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrevrangeByScoreWithScores)-有序集key中max和min之间所有的成员-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Object> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Object>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中成员member从大到小的排名
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public long zrevrank(String key,String member) {
		logger.info("(RedisService-zrevrank)-有序集key中成员member从大到小的排名-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zrevrank", httpEntity, JSONObject.class);
		logger.info("(RedisService-zrevrank)-有序集key中成员member从大到小的排名-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 有序集key中成员member的score值
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public double zscore(String key,String member) {
		logger.info("(RedisService-zscore)-有序集key中成员member的score值-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/sortedSet/zscore", httpEntity, JSONObject.class);
		logger.info("(RedisService-zscore)-有序集key中成员member的score值名-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDoubleValue(RedisConstants.RESULT);
		}
		return result;
	}

	/************************** jredis SortedSet(有序集合) 命令工具方法 ****************************/

	// TODO HyperLogLog
	/************************** jredis HyperLogLog（HyperLogLog) 命令工具方法 ****************************/
	/**
	 * 将一个数量的元素添加到指定的HyperLogLog里面
	 * @param key
	 * @param element
	 * @return JSONObject
	 */
	@Override
	public long pfadd(String key,String element) {
		logger.info("(RedisService-pfadd)-将一个数量的元素添加到指定的HyperLogLog里面-传入参数, key:{}, element:{}", key, element);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("element", element);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/pfadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfadd)-将一个数量的元素添加到指定的HyperLogLog里面-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 将多个数量的元素添加到指定的HyperLogLog里面
	 * @param key
	 * @param element
	 * @return JSONObject
	 */
	@Override
	public long pfaddArray(String key,String[] elements) {
		logger.info("(RedisService-pfaddArray)-将多个数量的元素添加到指定的HyperLogLog里面-传入参数, key:{}, elements:{}", key, Arrays.toString(elements));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("elements", elements);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/array/pfadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfaddArray)-将多个数量的元素添加到指定的HyperLogLog里面-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回储存在给定键的HyperLogLog的近似基数
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long pfcount(String key) {
		logger.info("(RedisService-pfadd)-返回储存在给定键的HyperLogLog的近似基数-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/pfcount", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfadd)-返回储存在给定键的HyperLogLog的近似基数-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回储存在给定键的HyperLogLog的近似基数
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public long pfcountArray(String[] keys) {
		logger.info("(RedisService-pfcountArray)-返回储存在给定键的HyperLogLog的近似基数-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/array/pfcount", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfcountArray)-返回储存在给定键的HyperLogLog的近似基数-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 将一个HyperLogLog合并（merge）为一个HyperLogLog
	 * @param dstkey
	 * @param sourcekey
	 * @return JSONObject
	 */
	@Override
	public String pfmerge(String dstkey,String sourcekey) {
		logger.info("(RedisService-pfmerge)-将一个HyperLogLog合并（merge）为一个HyperLogLog-传入参数, dstkey:{}, sourcekey:{}", dstkey, sourcekey);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("sourcekey", sourcekey);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/pfmerge", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfmerge)-将一个HyperLogLog合并（merge）为一个HyperLogLog-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 将多个HyperLogLog合并（merge）为一个HyperLogLog
	 * @param dstkey
	 * @param sourcekeys
	 * @return JSONObject
	 */
	@Override
	public String pfmergeArray(String dstkey,String[] sourcekeys) {
		logger.info("(RedisService-pfmergeArray)-将多个HyperLogLog合并（merge）为一个HyperLogLog-传入参数, dstkey:{}, sourcekeys:{}", dstkey, Arrays.toString(sourcekeys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dstkey", dstkey);
		params.put("sourcekeys", sourcekeys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/hyperLogLog/array/pfmerge", httpEntity, JSONObject.class);
		logger.info("(RedisService-pfmergeArray)-将多个HyperLogLog合并（merge）为一个HyperLogLog-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}
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
	@Override
	public long geoadd(String key,long longitude,long latitude,String member) {
		logger.info("(RedisService-geoadd)-将给定的空间元素（纬度、经度、名字）添加到指定的键里面-传入参数, key:{}, longitude:{}, latitude:{}, member:{}", key, longitude, latitude, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("longitude", longitude);
		params.put("latitude", latitude);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/geoadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-geoadd)-将给定的空间元素（纬度、经度、名字）添加到指定的键里面-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 将给定的空间元素（纬度、经度、名字）添加到指定的键里面
	 * @param key
	 * @param memberCoordinateMap
	 * @return JSONObject
	 */
	@Override
	public <T> long geoaddMap(String key,Map<String, T> memberCoordinateMap) {
		logger.info("(RedisService-geoadd)-将给定的空间元素（纬度、经度、名字）添加到指定的键里面-传入参数, key:{}, memberCoordinateMap:{}", key, memberCoordinateMap);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("memberCoordinateMap", memberCoordinateMap);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/map/geoadd", httpEntity, JSONObject.class);
		logger.info("(RedisService-geoadd)-将给定的空间元素（纬度、经度、名字）添加到指定的键里面-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		long result = -1l;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getLongValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回所有给定位置元素的位置（经度和纬度）
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	public List<?> geopos(String key,String member) {
		logger.info("(RedisService-geopos)-返回所有给定位置元素的位置（经度和纬度）-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/geopos", httpEntity, JSONObject.class);
		logger.info("(RedisService-geopos)-返回所有给定位置元素的位置（经度和纬度）-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<?> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<?>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回两个给定位置之间的距离
	 * @param key
	 * @param member1
	 * @param member2
	 * @return JSONObject
	 */
	@Override
	public double geodist(String key,String member1,String member2) {
		logger.info("(RedisService-geodist)-返回两个给定位置之间的距离-传入参数, key:{}, member1:{}, member2:{}", key, member1, member2);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member1", member1);
		params.put("member2", member2);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/geodist", httpEntity, JSONObject.class);
		logger.info("(RedisService-geodist)-返回两个给定位置之间的距离-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDoubleValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回两个给定位置之间的距离
	 * @param key
	 * @param member1
	 * @param member2
	 * @param unit
	 * @return JSONObject
	 */
	@Override
	public double geodistUnit(String key,String member1,String member2,String unit) {
		logger.info("(RedisService-geodist)-返回两个给定位置之间的距离-传入参数, key:{}, member1:{}, member2:{}, unit:{}", key, member1, member2, unit);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member1", member1);
		params.put("member2", member2);
		params.put("unit", unit);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/unit/geodist", httpEntity, JSONObject.class);
		logger.info("(RedisService-geodist)-返回两个给定位置之间的距离-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		double result = -1d;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = response.getDoubleValue(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 给定的经纬度为中心的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param longitude
	 * @param latitude
	 * @param unit
	 * @param radius
	 * @return JSONObject
	 */
	@Override
	public List<?> georadius(String key,long longitude,long latitude,String unit,double radius) {
		logger.info("(RedisService-georadius)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-传入参数, key:{}, longitude:{}, latitude:{}, unit:{}, radius:{}", key, longitude, latitude, unit, radius);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("longitude", longitude);
		params.put("latitude", latitude);
		params.put("unit", unit);
		params.put("radius", radius);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/georadius", httpEntity, JSONObject.class);
		logger.info("(RedisService-georadius)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<?> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<?>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

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
	@Override
	public List<?> georadiusParam(String key,long longitude,long latitude,String unit,double radius,String geoRadiusParam,long count) {
		logger.info("(RedisService-georadius)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-传入参数, key:{}, longitude:{}, latitude:{}, unit:{}, radius:{}, geoRadiusParam:{}, count:{}", key, longitude, latitude, unit, radius, geoRadiusParam, count);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("longitude", longitude);
		params.put("latitude", latitude);
		params.put("unit", unit);
		params.put("radius", radius);
		params.put("geoRadiusParam", geoRadiusParam);
		params.put("count", count);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/param/georadius", httpEntity, JSONObject.class);
		logger.info("(RedisService-georadius)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<?> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<?>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 以给定中心点的距离不超过给定最大距离的所有位置元素
	 * @param key
	 * @param membere
	 * @param unit
	 * @param radius
	 * @return JSONObject
	 */
	@Override
	public List<?> georadiusByMember(String key,String member,String unit,double radius) {
		logger.info("(RedisService-georadiusByMember)-以给定中心点的距离不超过给定最大距离的所有位置元素-传入参数, key:{}, member:{}, unit:{}, radius:{}", key, member, unit, radius);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		params.put("unit", unit);
		params.put("radius", radius);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/georadiusByMember", httpEntity, JSONObject.class);
		logger.info("(RedisService-georadiusByMember)-以给定中心点的距离不超过给定最大距离的所有位置元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<?> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<?>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

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
	@Override
	public List<?> georadiusByMemberParam(String key,String membere,String unit,double radius,String geoRadiusParam,long count) {
		logger.info("(RedisService-georadiusByMember)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-传入参数, key:{}, membere:{}, unit:{}, radius:{}, geoRadiusParam:{}, count:{}", key, membere, unit, radius, geoRadiusParam, count);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("membere", membere);
		params.put("unit", unit);
		params.put("radius", radius);
		params.put("geoRadiusParam", geoRadiusParam);
		params.put("count", count);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/param/georadiusByMember", httpEntity, JSONObject.class);
		logger.info("(RedisService-georadiusByMember)-给定的经纬度为中心的距离不超过给定最大距离的所有位置元素-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<?> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<?>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回一个位置元素的Geohash表
	 * @param key
	 * @param member
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> geohash(String key,String member) {
		logger.info("(RedisService-geohash)-返回一个位置元素的Geohash表-传入参数, key:{}, member:{}", key, member);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("member", member);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/geohash", httpEntity, JSONObject.class);
		logger.info("(RedisService-geohash)-返回一个位置元素的Geohash表-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 返回多个位置元素的Geohash表
	 * @param key
	 * @param members
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> geohashArray(String key,String[] members) {
		logger.info("(RedisService-geohashArray)-返回多个位置元素的Geohash表-传入参数, key:{}, members:{}", key, Arrays.toString(members));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("members", members);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/geo/param/geohash", httpEntity, JSONObject.class);
		logger.info("(RedisService-geohashArray)-返回多个位置元素的Geohash表-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<String> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<String>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/************************** jredis GEO（地理位置） 命令工具方法 ****************************/

	// TODO Transaction(事务) 命令工具方法
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/
	/**
	 * 取消事务
	 * @return JSONObject
	 */
	@Override
	public String discard() {
		logger.info("(RedisService-discard)-取消事务-传入参数为空");
		Map<String, Object> params = new HashMap<String, Object>();
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/discard", httpEntity, JSONObject.class);
		logger.info("(RedisService-discard)-取消事务-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 执行所有事务
	 * @return JSONObject
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> exec() {
		logger.info("(RedisService-exec)-执行所有事务-传入参数为空");
		Map<String, Object> params = new HashMap<String, Object>();
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/exec", httpEntity, JSONObject.class);
		logger.info("(RedisService-exec)-执行所有事务-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		List<Object> result = null;
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = (List<Object>) response.get(RedisConstants.RESULT);
		}
		return result;
	}

	/**
	 * 标记事务
	 * @return JSONObject
	 */
	@Override
	public String multi() {
		logger.info("(RedisService-multi)-标记事务-传入参数为空");
		Map<String, Object> params = new HashMap<String, Object>();
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/multi", httpEntity, JSONObject.class);
		logger.info("(RedisService-multi)-标记事务-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 取消WATCH命令对所有key的监视
	 * @return JSONObject
	 */
	@Override
	public String unwatch(String key) {
		logger.info("(RedisService-unwatch)-取消WATCH命令对所有key的监视-传入参数为空");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/unwatch", httpEntity, JSONObject.class);
		logger.info("(RedisService-unwatch)-取消WATCH命令对所有key的监视-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 监视一个key
	 * @param key
	 * @return JSONObject
	 */
	@Override
	public String watch(String key) {
		logger.info("(RedisService-watch)-监视一个key-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/watch", httpEntity, JSONObject.class);
		logger.info("(RedisService-watch)-监视一个key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}

	/**
	 * 监视多个key
	 * @param keys
	 * @return JSONObject
	 */
	@Override
	public String watchArray(String[] keys) {
		logger.info("(RedisService-watchArray)-监视多个key-传入参数, keys:{}", Arrays.toString(keys));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", keys);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/boot/redis/transaction/array/watch", httpEntity, JSONObject.class);
		logger.info("(RedisService-watchArray)-监视多个key-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String bootCode = Objects.toString(response.get(BootConstants.BOOT_CODE), "");
		String result = "";
		if (StringUtils.equals(bootCode, BootConstants.OK)) {
			result = Objects.toString(response.get(RedisConstants.RESULT), "");
		}
		return result;
	}
	/************************** jredis Transaction(事务) 命令工具方法 ****************************/

}