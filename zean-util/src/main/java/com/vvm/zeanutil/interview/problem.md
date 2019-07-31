问题集合
==
- 阻塞队列(平时这方面实现使用场景不多，所以短时间一下没反应过来)，后面实现了下，见：
  [阻塞队列实现](https://github.com/seuzxc/zean-microservice/blob/master/zean-util/src/main/java/com/vvm/zeanutil/interview/BlockedQueue.java)
   
- jvm监控，平时用的比较少，优化jvm也比较少
  ```
    一般的话在windows等可视化环境下可以用jdk下面的jconsole，jvisualVm，jprofile等(偶尔想研究下回看看，没有固定的必须去分析)
    生产环境一般都是linux，直接使用相关命令看内存的情况，top，jps，jstack，jstat等命令。
  ```  
     
- 查看jvm当前最耗资源的线程
     - 找到进程的pid  jsp -l 命令可以看到运行的进程的pid
     - 根据pid 查看当前进行的线程情况 top -H -p pid， 由此可以看到那个线程占用的内存多，cpu多
     - 线程pid转为16进制： printf "%x\n"
     - 打印出jvm当前堆栈信息： jstack -l pid |grep tid
      
     - eg:
     [pic1](https://github.com/seuzxc/tech/pic/jvmcheck1.png)
     [pic2](https://github.com/seuzxc/tech/pic/jvmcheck2.png)
- spring 和mybatis结合的原理 ：
     首先mybatis无论xml还是注解方式，都会将相应的配置解析存放到内存对象中，后续执行的时候可以根据sqlId或则方法取到具体的sql
 
- 市场上比较流行的微服务框架(以Spring cloud 相关组件搭建了个个人实验版: 含服务发现、配置中心、熔断、负载等)   
  
  [微服务示例](https://github.com/seuzxc/zean-microservice) 