/*atributos que estão no back-end e atraves dessa interface o angular vai enterder e
imprimir na tela para o usuario */

export interface User {
  id: Number | any;
  login: String | any;
  senha: String;
  nome: String | any;
  cpf: String | undefined;
  dataNascimento: String | undefined;
  // profissao: Profissao = new Profissao();
  // telefones: Array<Telefone>;
  // salario: DoubleRange;
}
