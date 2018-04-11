# XmlScript
利用反射进行简单规则功能实现

利用Java反射实现规则功能，可以进行java对象和js循环嵌套，规则变更无需重启服务，支持中文，支持文本格式自动识别。

${对象}的方式实现对Java对象的调用。

使用<bean id="打印" type = "method" value="${System.out.println}"/>方式绑定对象

type可以支持
