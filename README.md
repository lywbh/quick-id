# QuickId -- Simple id generator

##### 加锁一时爽，效率火葬场
##### 听说用乐观锁会好些，改天看看

## Installation
```xml
<dependency>
    <groupId>com.lyw</groupId>
    <artifactId>quick-id</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Configuration
#### properties:
```properties
quick-id.sharding-id=2019
quick-id.seq-bits=11
quick-id.sharding-bits=11
```
#### or yml:
```yaml
quick-id:
  sharding-id: 2019
  seq-bits: 11
  sharding-bits: 11
```

##### shardingId
实例ID，要保证每个实例不同
##### seq-bits
一个millisecond内的序号长度
##### sharding-bits 
实例ID的长度

##### seq-bits和sharding-bits可以不配置，默认都是11。
##### seq-bits + sharding-bits必须小于等于22，否则long型的id装不下会溢出。
##### sharding-id不要超出自己配置的大小，比如sharding-bits=4，就只能有0~15个实例。

## Use
```java
import com.lyw.quickid.utils.QuickIdUtils;
long id = QuickIdUtils.next();
```




###### 搞Spring就是逊啦
