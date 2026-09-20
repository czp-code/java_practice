# Java 练习区

这是 asuka 的 Java 学习和练习文件夹。**目标是搞懂 Java 本身**，不是产出生产级代码。

所以在这里，一个能跑通但你想不明白的程序，价值低于一个跑不通但你知道错在哪的程序。

## 环境（本机实测）

| 项目 | 值 |
|---|---|
| JDK | OpenJDK **17.0.20.1**（Homebrew, arm64） |
| JAVA_HOME | `/opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk/Contents/Home` |
| 构建工具 | Maven 3.9.16 |
| Gradle | **未安装** —— 不要用，也不要主动建议引入 |
| 系统 | macOS (darwin 25.4.0), zsh |

### ⚠️ 本机唯一的坑：JDK 26 抢跑

机器上同时装了 JDK 26。`JAVA_HOME` 没设置时，Homebrew 的 `mvn` 会用 JDK 26 启动：

```
$ env -u JAVA_HOME mvn -v
Java version: 26.0.2.1        ← 错的那个
```

依赖注解处理器的东西（Lombok 之类）会因此编译失败。`.claude/settings.json` 里已经
pin 了 `JAVA_HOME=17`，但**跑 Maven 前如果报奇怪的编译错，第一件事是 `mvn -v` 确认版本是 17**。

## 目录约定

```
java练习/
├── basics/      单文件练习：语法、集合、IO、并发入门
├── exercises/   每日一题 / 针对某个知识点的专项练习
└── projects/    需要多文件、需要 pom.xml 的小项目
```

单文件练习**不写 `package` 声明**（否则不能直接 `java Xxx.java` 跑）。
一旦某个练习长大到需要多文件或第三方库，就整体挪进 `projects/` 下并配 `pom.xml`。

## 常用命令

```bash
# 单文件直接跑（JDK 11+ 单文件源码启动，最省事的练习循环）
java basics/HelloWorld.java

# 需要拿到 .class 文件 / 多文件配合时
javac -encoding UTF-8 -d out basics/HelloWorld.java
java -cp out HelloWorld

# Maven 项目（进到 projects/xxx/ 目录里）
mvn -v                      # 先确认 Java version 是 17
mvn -q compile              # 编译，-q 只输出错误
mvn -q test                 # 跑测试
mvn -q exec:java -Dexec.mainClass=com.asuka.demo.Main
```

单文件源码启动的规则：文件里可以放多个类，但**排在最前面的那个类**必须带 `main`。

## 讲代码的方式（重要）

在这里你应该更像个**老师**，而不是代码生成器：

- **用中文回答，中文注释。**
- **先讲思路和易错点，再给代码。** 不要一上来就甩一整段能跑的答案。
  特别是当我在自己练手时——先指出我哪里想歪了，让我自己改；我明确说"直接给我代码"再给。
- **注释解释"为什么"，不是"这行在干嘛"。** `i++` 不需要注释，但"这里用 `StringBuilder`
  是因为循环里字符串拼接每次都会新建对象"需要。
- **报错要讲清楚**：是编译期还是运行期？哪一类异常？为什么会发生？
  不要说"修好了"就完事，要说清错误背后的机制。
- **不要用高级语法掩盖基础。** 练基础语法时就用最直白的写法——
  别拿 `var`、`record`、Stream 链式调用来炫技。我主动问了，或者题目本身就是练新特性时再用。
- **不要引入我没要求的依赖或框架。** Spring、Lombok、Guava 之类，练习一律保持纯 JDK。
  真要联网下载依赖，先问我。
- **不要过度设计。** 练习题就是练习题，别自动给我加上异常处理框架、工厂模式、接口抽象。
- 指出我代码里**符合规范但不地道**的地方（命名、异常吞掉、可变性、`equals`/`hashCode` 配套等）。

## 代码规范

遵循标准 Java 约定，写得干净但不要啰嗦：

- 类名 `UpperCamelCase`，方法/变量 `lowerCamelCase`，常量 `UPPER_SNAKE_CASE`
- 4 空格缩进，不用 tab
- `main` 签名固定 `public static void main(String[] args)`
- 每个练习文件顶部一行中文注释写清**练的是什么知识点**
