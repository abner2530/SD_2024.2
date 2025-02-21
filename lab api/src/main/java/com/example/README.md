Este laboratório demonstra a criação de uma API RESTful utilizando Jakarta EE (JAX-RS) e EJB Stateless, implantada em um servidor de aplicação Java EE, como o WildFly. A configuração inicial é feita no arquivo pom.xml, que especifica a dependência do Jakarta EE API e o plugin para empacotar a aplicação como um arquivo WAR, utilizado para o deploy no servidor.

Na implementação, foi criado um EJB Stateless, definido na classe HelloService. Este componente fornece a lógica de negócio da aplicação e é responsável por gerar uma mensagem personalizada de saudação baseada no nome fornecido como entrada. Por ser stateless, o EJB não mantém estado entre as requisições, tornando-o leve e adequado para este caso de uso.

A API RESTful foi configurada na classe HelloResource, que define o endpoint /hello/{name}. Esta classe utiliza a anotação @Inject para integrar o EJB e gerenciar a dependência do serviço de saudação. A anotação @PathParam é usada para capturar o parâmetro da URL, e o método retorna uma mensagem no formato text/plain ao cliente.

Para habilitar e expor a API RESTful, foi criada a classe RestApplication com a anotação @ApplicationPath("/api"), que define o caminho base da API como /api. Isso organiza as rotas RESTful sob uma estrutura clara e acessível a partir do navegador ou de ferramentas como cURL.

Após a configuração, o projeto é empacotado com Maven, gerando um arquivo WAR que é implantado na pasta standalone/deployments/ do WildFly. Com o servidor rodando, a API pode ser acessada via HTTP no endpoint /api/hello/{name}, respondendo com a saudação personalizada fornecida pelo EJB. Este fluxo demonstra a integração entre EJB e JAX-RS para fornecer um serviço simples, modular e escalável.
