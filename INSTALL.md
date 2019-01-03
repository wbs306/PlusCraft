## INSTALL(Windows/Linux/MacOS)
### Mod所需依赖
- Java 8
- Minecraft 1.12.2
- Minecraft Forge-1.12.2

### 编译
克隆仓库到本地

	git clone https://github.com/wbs306/PlusCraft.git
    cd PlusCraft/

开始构建

Linux/MacOS:

	./gradlew build
Windows:

	gradlew.bat build

出现`BUILD SUCCESSFUL`即编译完成

###安装
进入到`build/libs`目录下，`pluscraft-0.1.jar`为编译产物，将其复制到Minecraft目录下(`.minecraft`)的mods文件夹内即可

###参与开发

这里以Linux为例子，MacOS与Linux命令相同，Windows只需将`./gradlew`替换成`gradlew.bat`即可

进入到本地仓库目录，执行命令

	./gradlew setupDecompWorkspace
命令执行完毕之后，如果你的IDE是eclipse，执行

	./gradlew eclipse
如果更喜欢使用IntelliJIDEA，执行

	./gradlew idea
打开IDE，将工程目录切换到本地仓库的目录下即可。对于IDEA还需要在IDE中导入gradle才能运行