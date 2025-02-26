# Usa a imagem do Node.js como base
FROM node:18-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY package.json package-lock.json ./
RUN npm install

# Copia todo o restante do código para dentro do container
COPY . .

# Constrói a aplicação
RUN npm run build

# Usa o servidor Nginx para servir os arquivos estáticos
FROM nginx:alpine
COPY --from=0 /app/build /usr/share/nginx/html

# Expõe a porta do frontend
EXPOSE 80

# Inicia o Nginx
CMD ["nginx", "-g", "daemon off;"]
