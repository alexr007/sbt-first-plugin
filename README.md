## how to write plugin

### compile
```shell
sbt compile
```

### release
```shell
sbt publishLocal
```

### compile + release
```shell
sbt "compile ; publishLocal"
```

### inside `sbt` shell
```
reload ; compile ; publishLocal
```

### use it
inside another project,

file `project/plugins.sbt` should contain

`addSbtPlugin("org.alexr" % "plugin-1" % "0.0.5-SNAPSHOT")`

file `build.sbt` should contain

`enablePlugins(ScalaBootstrap)`

#### notes

- sbt plugin should be compiled with 2.12 (not 2.13)
