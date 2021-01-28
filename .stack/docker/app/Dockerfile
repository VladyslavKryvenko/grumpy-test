FROM adoptopenjdk/openjdk14-openj9

WORKDIR /app

COPY ./ ./

EXPOSE 8080

RUN apt-get install -y curl
RUN curl https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein > lein
RUN mv lein /usr/local/bin/lein
RUN chmod a+x /usr/local/bin/lein
RUN apt-get update
RUN apt-get install -y rlwrap
RUN apt-get install -y bash curl rlwrap
RUN curl -O https://download.clojure.org/install/linux-install-1.10.1.536.sh
RUN chmod +x linux-install-1.10.1.536.sh
RUN ./linux-install-1.10.1.536.sh

RUN mkdir grumpy_data
RUN ["./script/setup"]
CMD sleep 5 && rlwrap -r ./script/console