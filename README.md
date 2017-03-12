#Object转Map工具类
    1.objectToMap(Object obj)
        参数:
            object  传入的对象
        返回:
            Map<String,String> 
        返回值的构造
            key: 参数名
            value: 值String
    2.Map<String, String> objectToMapString(Object obj,String... param)
        参数:
            object  传入的对象
            param   **非必须** 参数0对时间格式化字符
                    默认格式化:2017-03-10 10:21
        返回:
            Map<String,String> 
        返回值的构造
            key: 简单类名.参数名
            value: 值为String
            