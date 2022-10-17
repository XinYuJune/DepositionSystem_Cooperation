# DepositionSystem_Cooperation
This is a cooperational item required by SoftWare Engineering.
It is the second demostrartion that we should work with together.
# 这是软件工程课的多人合作项目代码部分。

# 程序总览
    程序名称：居民业务储蓄系统
    程序版本：V0.1
    开发人员：彭俊、赵云鑫、董凤龙
    开发语言：Java
    代码管理：Github
    开发文档：待补充和完善
    UML图：见Recourse目录
# 各流程负责人
    总负责：彭俊
    类图和活动图绘制：赵云鑫、董凤龙
    代码编写：彭俊

# 程序需求分析
    储蓄业务系统：分为查询余额、取款、存款三个业务场景。首页显示这三个场景，并显示由用户的ID以及姓名组成的欢迎语。

    # 查询余额
        可以查询到当前用户的余额信息；定期存款还可以查询到定期存款的到期时间以及对应的利率信息。

    #取款
        用户可以输入金额进行取款操作，选择取活期还是定期；
        取款后显示用户当前的余额信息，若是定期存款则需要到期才能取出。

    #存款
        用户可以选择存入定期还是活期，若选择活期则直接存入。
        选择定期则再次引导用户选择六个存款档位，完成存款。

    

# 程序介绍
    本系统为储蓄业务系统。采用Java语言编写，含有存款、取款、查询余额，计算利息等功能。
    还可以显示储蓄业主姓名、账号等用户信息（已经提前准备好，可在Deposition类的中的属性进行修改）。
    本系统较为简单，采用控制台输入输出，没有采用主流SSM面向对象开发模式进行开发。


# 项目选题：

    居民个人储蓄存取款业务问题

# 项目要求：

    （1） 进行双人项目组对，采取自愿的原则，两人一组（不允许跨班组队，每班至多有一个三人组），在10.4晚20点前将组对情况发送给管理该班的助教（由其中一人发送给该人对应的助教即可，另一人不需发送），发送格式：班级-姓名1-姓名2；

    管理该班的助教共同对组对情况进行核查，确保无重复无遗漏，出现解决不了的问题及时与任课教师联系，请助教在当天完成核查工作；

    助教以班级为单位对该班的分组进行统一编号，商定管理范围（基本原则：均等原则），然后各自将自己管理的分组情况发送到课程QQ群，发送格式：班级-组号-姓名1-姓名2；

    （2） 在单人项目成果的基础上进行功能完善；

    （3） 按照“软件结构设计（模块划分）- 算法设计（模块的处理流程）- 编码（依据规范编写代码）- 测试（单元测试和功能测试）”的流程进行开发；

    （4） 列出任务清单，并指定完成人（任务分配原则：可以两人共同讨论完成某项任务，也可以指定某人完成某项任务；每人必须负责至少一个模块的编码任务；每项任务给出估计的起止时间）；

    （5） 给出软件结构和算法设计的结果，用建模工具画类图和关键模块的UML活动图（可以复用单人项目中的制品）（）（注意：这里强调用面向对象的类图和活动图完成，如果之前用的是层次图和程序流程图需要重新绘制）；

    （6） 制定简要的小组编码规范，作为双人项目报告的附件；

    （7） 编写源程序代码（可以复用单人项目中的制品）；

    （8） 依据小组编码规范和复审核查表对设计和源程序代码进行自我复审和伙伴复审，对复审发现的问题进行记录，并给出解决方案，对前期的设计与编码进行修改和调整。复审发现的问题要在双人项目报告中明确描述出来。

    （9） 可以尝试采用结对编程方式进行开发；

    （10） 复审时注意单一职责原则和开放封闭原则的应用情况；

    （11） 给出运行界面截图；

    （12） 构建单元测试，代码覆盖率达到100%；（选做，完成加分）

    （13） 构建功能测试，对功能和接口进行全面测试；

    （14） 按照任务清单，给出完成各项任务的估计时间和实际时间；

    （15） 在截止时间前提交。
# 程序总体流程图
![](https://github.com/XinYuJune/DepositionSystem_Cooperation/raw/main/Recourse/Flow_Total.png)