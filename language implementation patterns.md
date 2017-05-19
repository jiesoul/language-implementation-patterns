# Language Implementation patterns
  Create Your Own Domain-Specific and General Programming Languages

## Preface

## Getting Started with Paresing

### Language Applications Cracked Open 

四个阶段：

![](media/language-application-pipeline.png)

* Rader：从输入流构建数据结构，输入流通常是文件而非二进制数据。
* Generator：  A generator walks an internal data structure and emits output. Examples include object-to-relational database mapping tools, object serializers, source code generators, and web page generators.
* Translator or Rewriter: 读取文本或二进制输入，输出相等的其它语言。
* Interpreter: 读取，解码，和执行指令。

Bytecode Interpreter

![](media/Bytecode-interpreter-pipeline.png)

Source-level Bug Finder

![](media/Source-level bug-finder-pipeline.png)

Java Bug Finder

![](media/recognizes-Java-code-and-builds-an-IR.png)

Java Bug Finder Part Deux

![](media/Java-bug-finder-pipeline-feeding.png)

C compilation process 

![](media/C-compilation-process-pipeline.png)

C compiler application

![](media/Isolated-C-compiler-application-pipeline.png)

C++ (cfront) compilation process

![](media/C++compilation process pipeline.png)

### 基本解析模式 Basic Parsing Patterns 

* 模式1 映射语法到递归下降识别器，这个模式告诉我们怎么转换语法(正式语言规范)到手工解析器，它被用于下面三个模式。
* 模式2 LL(1)递归下降词法分析器，这个模式把字符流转换为单词，供解析器使用。
* 模式3 LL(1)递归下降解析器，这是最广为人知的递归下降解析模式。它仅仅扫描最近的输入解析。对于每个语法规则，对应在解析器中一个解析方法。
* 模式4 LL(k)递归下降解析器，它增强了一个LL(1)解析器，它按规则超前扫描多个符号来做解析。

#### 识别短语结构 Identifying Phrase Structure

单词做为做为解析树的叶子节点。

#### 构建递归下降解析器

解析器检查一个句子是否遵守语言的句法。解析器并不在内存中构建树结构，它仅仅识别各种基础构造和相关联的单词。

语言有无限的句法，我们不能一一解释它们。基于一些原因我们需要DSL(领域特定语言)去规范语言。

#### 使用语法 DSL 解析器构建

#### 词法分析句子

识别字符流叫做词法分析器。全部的句子有结构，单独的单词有结构。在字符级别我们描述句法用词法结构。语法解释语言结构。因此我们能使用它们做为词法规范。

小心左递归导致无限循环。

### 增强解析模式 Enhanced Parsing Patterns

* 模式5 回溯解析器 这个模式为递归下降解析器添加一个推断解析设施。回溯解析器尝试评估在顺序上直到它们中的一个匹配当前输入。
* 模式6 Memoizing Parser 记忆解析器，这个模式能显著提升性能在一个小内存上。
* 模式7 Predicated Parser 谓词解析器，这个模式允许我们改变解析器控制流使用叫做句法谓词的逻辑表达式。

这些模式手工实现是单调的，但是理解它们怎么工作是重要的。

#### Parsing with Arbitrary Lookahead 任意超前解析




## Analyzing Languages
### Building Intermediate Form Trees
### Walking and Rewriting Trees
### Tracking and Identifying Program Symbols
### Managing Symbol Tables for Data Aggregate
### Enforcing Static Typing Rules
## Building Interpreters
### Building High-level Interpreters
### Building Bytecode Interpreters
## Translating and Geneating Language
### Translating Compuer Languages
### Generating DSLs with Templates
### Puttinig It All Together
