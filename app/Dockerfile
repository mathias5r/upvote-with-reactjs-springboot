FROM node:8-alpine

RUN apk add --update \
		make

# The base node image sets a very verbose log level.
ENV NPM_CONFIG_LOGLEVEL warn

# Copy all local files into the image.
COPY . .
COPY package.json package.json
COPY package-lock.json package-lock.json
RUN npm install

# Build for production.
RUN npm run build --production

# Install `serve` to run the application.
RUN npm install -g serve

# Install 'jest' to run the tests
RUN npm install -g jest

# Set the command to start the node server.
CMD serve -s build

# Tell Docker about the port we'll run on.
EXPOSE 5000