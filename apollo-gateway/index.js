/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

const { ApolloServer, gql } = require('apollo-server');
const {ApolloGateway} = require('@apollo/gateway')

const gateway = new ApolloGateway({
    serviceList: [
        { name: 'movies', url: 'http://localhost:8081/graphql' },
        { name: 'reviews', url: 'http://localhost:8085/graphql' },
        { name: 'critic', url: 'http://localhost:8083/graphql' },
        { name: 'actors', url: 'http://localhost:8087/graphql' },
    ]
});
const hostname = '192.168.1.52';
const port = 3000;
const server = new ApolloServer({ gateway, subscriptions:false, tracing:true });
server.listen(port, hostname);
