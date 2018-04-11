# XmlScript
利用反射进行简单规则功能实现

利用Java反射实现规则功能，可以进行java对象和js循环嵌套，规则变更无需重启服务，支持中文，支持文本格式自动识别。

使用RulesLoad.Load("此处放规则xml文件位置","此处放置需要执行的规则名")语句进行对规则调用;

使用import标签导入class。

使用include标签实现对其他xml规则的引入。

使用<bean id="对象" type = "method" value="${value}"/>方式绑定对象。

${对象}的方式实现对Java对象的再次调用。

bean标签type属性可以支持int/byte/short/long/double/float/char/boolean基本类型，还可支持string类型。

可以用type="method"对用${value}表达式包括的方法进行注入，value指定对应方法。

type="object"实现对${value}对象的注入，支持new Object()形式注入对象。

type="function"实现对${value}对象预处理，在再次使用${对象}调用时，执行创建对象。

<result>标签下<value>标签或value属性内书写${对象}形式执行规则。

可以使用#[js表达式]的形式在其中书写js表达式，js表达式可以与规则对象${对象}进行相互嵌套。

例如一个简单逻辑的判断，小明去买冰淇淋，如果小明买的冰淇淋价格大于5元，那么打印“小明买的贵了！！！”顺便打印“冰淇淋价格”，下方展示两种不同方式实现逻辑：

方式1：

        <result type="execute">

            <value>

                ${打印(小明开始去买冰淇淋，时间：${日期格式化(${new Date()})})}

            </value>

        </result>

        <bean id="小明买到的冰淇淋的价格" type = "object" value="${小明去买冰淇淋}"/>
        
        <if evl = "#[${小明买到的冰淇淋的价格}>5]">

            <true>

                <result type="execute">

                    <value>

                        ${打印(小明买的贵了！！！价格：${小明买到的冰淇淋的价格}元)}

                    </value>

                </result>

            </true>

            <false>

                <result type="execute">

                    <value>

                        ${打印(刚刚好，还不错！价格：${小明买到的冰淇淋的价格}元)}

                    </value>

                </result>

            </false>

        </if>

        <result type="execute">

            <value>

                ${打印(小明买完冰淇淋了，时间：${日期格式化(${new Date()})})}

            </value>

        </result>

方式2：

        <result type="execute">

            <value>

                ${打印(小明开始去买冰淇淋，时间：${日期格式化(${new Date()})})}

                #[

                    importClass(java.lang.System)

                    var prise=${小明去买冰淇淋};

                    if(prise>5){

                        System.out.println("小明买的贵了！！！价格："+prise+"元");

                    }else{

                        System.out.println("刚刚好，还不错！价格："+prise+"元");

                    }

                ]

                ${打印(小明买完冰淇淋了，时间：${日期格式化(${new Date()})})}

            </value>
