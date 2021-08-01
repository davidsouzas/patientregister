<h4 align="center"> 
  PatienteRegister 
</h4>

# JAVA
  -Versão 11 Utilizada
# MySQL
  -Versão 8.0.20 MySql Community Server
# Informações
  - Servidor tomcat provido pelo spring starta na porta 8080, pode alterar no <a target="_blank" href="https://github.com/davidsouzas/patientregister/blob/master/pom.xml">POM</a>
# Front
  - O Front dessa aplicação está disponivel <a target="_blank" href="https://github.com/davidsouzas/front-paciente">Aqui</a>
# Observações
  - A autenticação foi feita através da classe SecureRandom gerando um token randomico Visualize aqui <a target="_blank" href="https://github.com/davidsouzas/patientregister/blob/master/src/main/java/com/devtest/patientregister/resources/LoginResource.java">Aqui</a>
    Esse token é gerado no login, é setado para expirar depois de 10 horas e através da consulta no banco é gravado o token, validade, tempo para expirar e a que classe ele
    pertence(enfermeiro ou medico).
  
 
