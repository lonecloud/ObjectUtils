

# Object转Map工具类

1. objectToMap(Object obj)
- 参数:
    -  object  传入的对象
- 返回:
    - Map<String,String> 
- 返回值的构造
    - key: 参数名
    - value: 值String
2. Map<String, String> objectToMapString(String timeFormatStr, Object obj, String... excludeFields)
参数:
- timeFormatStr **非必须** 对时间格式化字符默认格式化:2017-03-10 10:21
- object  传入的对象
- excludeFields   需要排除的对象 
- 传入格式: 
    - User 对象中有三个属性id,name,year 
    - 排除name 则输入User.name 
- 返回:
  - Map<String,String> 
- 返回值的构造
  - key: 简单类名.参数名
  - value: 值为String
            
