FROM node:8-alpine

RUN apk add --update \
		make

# The base node image sets a very verbose log level.
ENV NPM_CONFIG_LOGLEVEL warn

# Copy all local files into the image.
COPY . ./app
WORKDIR ./app

# Install dependencies
RUN npm install

# Build for production.
RUN npm run build --production

# Install `serve` to run the application.
RUN npm install serve --save

# Install 'jest' to run the tests
RUN npm install jest --save

# Set the command to start the node server.
CMD serve -s build

# Tell Docker about the port we'll run on.
EXPOSE 5000
