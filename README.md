# 答题微信小程序 accesstoken 管理服务

项目主要基于 [Spring Boot](https://spring.io/projects/spring-boot) 和 [Mybatis](https://mybatis.org/mybatis-3)，为 [howcurious/survey](https://github.com/howcurious/survey) 提供简单的微信小程序 accesstoken 管理服务。

主要考虑 [Redis](https://redis.io) 部署成本略高，故通过此服务简单代替，此服务无法保证高可用。

## 安装

项目使用 [Maven](https://maven.apache.org) 和 [Lombok](https://projectlombok.org)。请确保正确配置 Maven，并在 IDE 中安装 Lombok 插件。

## 使用说明

为保证开发与生产相隔离，开发配置（dev，默认配置）与生产配置（prod）的微信小程序 appId 及 appSecret 应不同。

为避免不同实例的 accesstoken 相互覆盖，服务实例的数量只能为 1。

### 部署镜像于 [Kubernetes](https://kubernetes.io)

[Dockerfile](Dockerfile) 既可用于在 Docker Hub 中关联 GitHub 账户后自动构建镜像，也可用于通过如下命令手工制作镜像。

```
docker build . -t myImageName:myImageTag
```

### 部署 jar 包于服务器

可通过如下命令构建 jar 包。

```
mvn clean package -Dmaven.test.skip=true -P prod
```

## 相关仓库
- [howcurious/survey](https://github.com/howcurious/survey) — 答题微信小程序服务端。

## 维护者

[@howcurious](https://github.com/howcurious)。

## 如何贡献

🍉 [提一个 Issue](https://github.com/howcurious/accesstoken/issues/new) 或者提交一个 Pull Request。

## 使用许可

[MIT](LICENSE) © howcurious
