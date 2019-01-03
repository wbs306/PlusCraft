## FAQ

Q: 这是什么项目?
A: 这个项目是为Minecraft开发的一个Mod，用于将Minecraft积木化，接入Scratch

Q: 谁可以参与这个项目？
A: 任何对这个项目感兴趣的人

Q: 为什么我执行setupDecompWorkspace过程那么缓慢?
A: 这个过程需要下载大量的依赖包，以及MCP的代码，由于服务器均位于国外，可考虑使用代理加速。
>使用socks代理：
>
>	 ./gradlew setupDecompWorkspace -DsocksProxyHost=<host> -DsocksProxyPort=<port>
>使用https代理：
>
>	 ./gradlew setupDecompWorkspace -Dhttps.proxyHost=<host> -Dhttps.proxyPort=<port>
>使用http代理：
>
> 	./gradlew setupDecompWorkspace -Dhttp.proxyHost=<host> -Dhttp.proxyPort=<port>