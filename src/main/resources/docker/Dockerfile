#edu-management

FROM java8_curl

COPY edu-management.jar start.sh /home/

RUN chmod 777 /home/start.sh

WORKDIR /home

EXPOSE 9005 2000

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD ["/bin/bash", "./start.sh", "$CFGURL"]
