# Sử dụng nginx làm base image
FROM nginx:stable-alpine

# Set thư mục làm việc trong container
WORKDIR /usr/share/nginx/html

# Xóa sạch file mặc định của nginx
RUN rm -rf ./*

# Copy build Angular vào container
COPY dist/frontend/browser .

# Copy file config nginx (nếu có, hoặc skip nếu chưa cần)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 để container lắng nghe
EXPOSE 80

# Start nginx
CMD ["nginx", "-g", "daemon off;"]
