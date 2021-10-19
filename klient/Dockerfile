FROM nginx:1.21.3-alpine

COPY vhost.conf /etc/nginx/conf.d/default.conf
COPY dist /usr/share/nginx/html/public/
COPY src/client/index.html /usr/share/nginx/html

