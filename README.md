# live-client-springboot

all services:

live-server-nginx

live-server-callback

<b>live-client-springboot</b>

live-config


*this service has spring cloud config in it, so we get configuration from config server.

http-flv-apollo是对应的apollo配置中心，启动时需要配置以下参数：APOLLO_META=http://106.75.249.249:8080 ENV=dev

*adding a env to locate a config server url as below:

docker run -d -p port:8000 -e APOLLO_META=http://106.75.249.249:8080 -e ENV=dev IMAGENAME
