***********************************************
*****PROJECT-SPRING-BOOT-REST******************
***********************************************

1 - ]
	criar projeto via npm
		 ng new EderSpringRESTMAIN

	 - Depemdencia
		 #npm version
		{
		  'eder-spring-restmain': '0.0.0',
		  npm: '8.11.0',
		  node: '16.15.0',
		  v8: '9.4.146.24-node.20',
		  uv: '1.43.0',
		  zlib: '1.2.11',
		  brotli: '1.0.9',
		  ares: '1.18.1',
		  modules: '93',
		  nghttp2: '1.47.0',
		  napi: '8',
		  llhttp: '6.0.4',
		  openssl: '1.1.1n+quic',
		  cldr: '40.0',
		  icu: '70.1',
		  tz: '2021a3',
		  unicode: '14.0',
		  ngtcp2: '0.1.0-DEV',
		  nghttp3: '0.1.0-DEV'
		}

		-
		#npm -v
			8.11.0

		-
		#ng version
			Angular CLI: 13.2.6
			Node: 16.15.0
			Package Manager: npm 8.11.0
			OS: win32 x64

		-
		#node -v
			v16.15.0

 2 - ]
	Instalando BootStrap e Layout de Login
		#npm install bootstrap --save

		up to date, audited 1157 packages in 2s
		124 packages are looking for funding
		  run `npm fund` for details

		found 0 vulnerabilities

		#npm i jquery --save

		up to date, audited 1159 packages in 2s

		124 packages are looking for funding
		  run `npm fund` for details

		found 0 vulnerabilities

		#npm i popper.js@1.14.3 --save

		up to date, audited 1159 packages in 2s

		124 packages are looking for funding
		  run `npm fund` for details

		found 0 vulnerabilities

3 - ]
	criando a interface de login 
		no app.component.html atualizar para 
		
			<div class="content" role="main">
			  <section class="vh-100">
				<div class="container-fluid">
				  <div class="row">
					<div class="col-sm-12 text-black">
					  <div class="px-5 ms-xl-4">
						<i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085"></i>
						<span class="h1 fw-bold mb-0">Acesso ao Sistema</span>
					  </div>
					  <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 pt-5 pt-xl-0 mt-xl-n5">
						<!--  -->
						<form class="form mt-4" style="width: 23rem">
						  <div class="form-outline mb-4">
							<input type="text" name="usuario" class="form-control form-control-lg"
							  placeholder="Informe o usuario..." required />
							<!-- validaçao do campo -->
						  </div>
						  <div class="form-outline mb-4">
							<input type="password" name="senha" class="form-control form-control-lg"
							  placeholder="Informe a senha..." required />
							<!-- validaçao do campo -->
						  </div>
						  <div class="pt-1 mb-4">
							<button class="btn btn-info btn-lg btn-block" type="submit" style="width: 23rem">
							  Acessar
							</button>
						  </div>
						  <p>
							Não tem uma conta ? <a class="link-info">Registre-se Aqui</a>
						  </p>
						</form>
					  </div>
					</div>
				  </div>
				</div>
			  </section>

		3.1 - 
		 NgModel e Formulário
			em app.module.ts para caputar as informações enviados no formulado da tela de login
				atualizar 
				import { FormsModule } from '@angular/forms';	
				..
					
					  imports: [
						BrowserModule,
						FormsModule
					  ],
					  
		3.2 - ]
			em app.component.ts será a classe que vai receber os valores que vem do formulário 
			atualizar
				
			 export class AppComponent {	
			  title = 'EderSpringRESTMAIN';

			  /*ao instaciar essa classe*/
			  user =  {login : '', senha : ''}
			  
			  - e no formulário html 
				dentro do input login e senha informar o elemento [(ngModel)] responsavel por ligar o form html
				a classe que App.component
					atualizar	
						<input type="text" name="login" [(ngModel)] = "user.login" id="login" class="form-control form-control-lg"
						placeholder="Informe o usuario..." required />
						<!-- validaçao do campo -->
					</div>
						<div class="form-outline mb-4">
						<input type="password" name="senha" [(ngModel)] = "user.senha" id="senha" class="form-control form-control-lg"
						placeholder="Informe a senha..." required />
					</div>
							  
              
						
		3.3 - ]
			criar metodo pegar os dados do formulário 
				em app.component.ts	criar metodo abaixo
					/*função que o botão acessar da tela de login */
					  public login(){
						console.log("Test Login " + this.user.login + "senha :" + this.user.senha)
					  }
					  
				atualizar o formulário 
						<div class="pt-1 mb-4">
                <button class="btn btn-info btn-lg btn-block" type="submit" (click)="login()" style="width: 23rem">
                  Acessar
                </button>
              </div>
			  
		
			/*TESTE de CAPITURAR OS DADOS DO FORMULÁRIO*/
			
			- compilar o sistema, + F12 e clicar no botão Acessar, e conferir se o resultado foi impresso:
				
				Resultado:
				
				Test Login edersenha :tux
				
		3.4 - 
			criar a constante de conexão com a API
				na pasta /src/app executar
					
				#ng generate class AppConstants	
					CREATE src/app/app-constants.spec.ts (179 bytes)
					CREATE src/app/app-constants.ts (30 bytes)
					
			3.4.1 -] 
				em AppConstants
					atualizar
						export class AppConstants {
						  public static get baseServe(): string {
							return 'http://localhost:9000/';
						  }
						  public static get baseLogin(): string {
							return this.baseServe + 'springProjectRestAPI/login';
						  }
						  public static get baseUrl(): string {
							return this.baseServe + 'springProjectRestAPI/usuario/';
						  }
						}
						
		3.5 - ] 
			importar o HttpClientModule no app.module	
				- essa importação permite que os metodos mapeados na classe de indexController possa ser localizadas 
				no angular 
					atualizar
						import { HttpClientModule } from '@angular/common/http';
						..
						
						  imports: [
							BrowserModule,
							FormsModule,
							HttpClientModule
						  ],
						  
						  
		3.6 - ]
			criar o Service
				criar a pasta service e dentro dela
					executar 
					#ng generate s LoginService  
						CREATE src/app/service/login-service.service.spec.ts (388 bytes)
						CREATE src/app/service/login-service.service.ts (141 bytes)
						
				3.6.1 - 
					instaciar objeto construtor hhtpClient
						atualizar
							import { HttpClient } from '@angular/common/http';
							...
							export class LoginServiceService {

								  constructor(private http : HttpClient) { }
								  
								    login(user){
    
									}
								}
					- importar no app.component	o LoginService
							atualizar
							import { LoginServiceService } from './service/login-service.service';
							..
							
							/*criar constructor */
							  constructor (private loginServiceService : LoginServiceService){}

							  /*função que o botão acessar da tela de login */
							  public login(){
								this.loginServiceService.login(this.user);
								//console.log("Test Login " + this.user.login + "senha :" + this.user.senha)
							  }
							
				/*RESUMO QUANDO O USUARIO CLICAR EM ACESSAR NO HTML, ELE CHAMA A FUNÇÃO LOGIN E AGIRA VAI CHAMAR O SERVICE loginService, o service vai receber o user, e o precesso vai acontecer no Loginservice recebendo o usuario e senha passado pelo component e recebidos.*/ 			
														
		3.7 - ]
			atualizar em login-service.service
				/*metodo vai recebendo os valores coletados e atribuidos a user*/
				  login(user: any) {
					console.info('Login Service : ' + user.login);
					return this.http
					  .post(AppConstants.baseLogin, JSON.stringify(user))
					  .subscribe(
						(data) => {
						  /*Retorno hhtp */
						  /*validando rertorno, pega somente a string do token removendo o ' ' e o Bearer */
						  var token = JSON.parse(JSON.stringify(data)).Authorization.split(' ')[1];
							/*armazenar atras do frontend o valor recebido do servidor */
						  localStorage.setItem("token", token);
						  /*só para exibir no console do navegador */
						  //console.info("Token : " + localStorage.getItem("token"));
						},
						/*tratar caso tiver alguma error ao tentar logar*/
						(error) => {
						  console.log('Login Incorreto');
						}
					  );
				  }
				  
		/*TESTE Unitário*/
			- compilar o projeto usando:
				na pasta do projeto executar 
				#npm start 
			
			- executar a API 
				na pasta target do projeto da API 
				#java -Dserver.port=9000 -jar ProjetoSpring-0.0.1-SNAPSHOT.jar
				
				/*sendo que o -Dserver.port=9000 define a porta que deseja executar a API, porem a constante do projetoMain
				precisam ser o s mesmo*/
				
			- Abrir no navegador 
				//localhost:4200
				- a tela de login deve surgir e informe os dados:
				
				login : admin
				senha : 1234
				
			Resultado: F12
				Console =>
				
				Login Service : admin
				Token Gerado
				
				Network =>
				
				login => Request URL: http://localhost:9000/springProjectRestAPI/login
						Request Method: POST
						Status Code: 200 
						
						Hearders
							Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY2NTEzMjE0OX0.9DZ16_wtdBQ1JX4sQ0WE3uthYcsjR-27koaHoSDWsb6UNt_6H_wpUr5XFM5Uznc4nzQ9izYDiTwgH56o7S9KIg
				
8 - ]
	Validando formulário de login
		atualizar app.component.html
		form class="form mt-4" style="width: 23rem" class="was-validated">
              <div class="form-outline mb-4">
                <input type="text" name="login" [(ngModel)] = "user.login" id="login" class="form-control form-control-lg"
                 placeholder="Informe o usuario..." value="Mark" required>
                 <div class="valid-feedback">Valid.</div>
                 <div class="invalid-feedback">Please fill out this field.</div>
                <!-- validaçao do campo -->
              </div>
              <div class="form-outline mb-4">
                <input type="password" name="senha" [(ngModel)] = "user.senha" id="senha" class="form-control form-control-lg"
                placeholder="Informe a senha..." required>
                  <div class="valid-feedback">Valid.</div>
                  <div class="invalid-feedback">Please fill out this field.</div>
                <!-- validaçao do campo -->
             </div>
		/*https://projetojavaweb.com/certificado-aluno/plataforma-curso/aulaatual/a57189a7-cf34-48cd-824d-22d44ecede96/idcurso/1/idvideoaula/807*/
		
9 - ]
	Criando Routers [Rotas] para a nossa Home
			9.1 - CRIAR COMPONENTE home
		Executar
		#ng g c home 
			CREATE src/app/home/home.component.html (19 bytes)
			CREATE src/app/home/home.component.spec.ts (612 bytes)
			CREATE src/app/home/home.component.ts (267 bytes)
			CREATE src/app/home/home.component.css (0 bytes)
			UPDATE src/app/app.module.ts (556 bytes)
			
			9.2 - Mapeamento do componente criado 
				em app.module.ts	
					atualizar
					import { RouterModule, Routes } from '@angular/router';
					import { ModuleWithProviders, NgModule } from '@angular/core';
					....
					export const appRouters: Routes =[
					  {
						/*quando passar a url  http://localhost:4200/home ele vai chamar o componet HomeComponent*/
						path : 'home', component : HomeComponent
					  },
					  {
						/*quando passar a url  http://localhost:4200/login ele vai chamar o componet AppComponent*/
						path : 'login', component : AppComponent
					  }
					];
					/*exportando o modulo ModuleWithProviders<type-argument> para que ele possa ler o array de rotas acima */
					export const routes : ModuleWithProviders = RouterModule.forRoot(appRouters);
										
										
					..
					imports: [
						BrowserModule,
						FormsModule,
						HttpClientModule,
						routes,
					  ],
					  
					 export class AppModule { }
					/*https://splunktool.com/jwt-library-error-generic-type-modulewithproviderst-requires-1-type-arguments-in-angular-10*/
					declare module "@angular/core" {
					  interface ModuleWithProviders<T = any> {
						  ngModule: Type<T>;
						  providers?: Provider[];
					  }
					  
			9.3 - Redirecioanr para o Home
					em login.service.service	
						declarar o Router
							import { Router } from '@angular/router';
							...
							/*declarar no constructor*/
								constructor(private http: HttpClient, private router : Router){}
								..
							 /*navegação para onde vai depois de autenticar */
							this.router.navigate(['home']);
				
			9.4 - Adicionar no app.componet.html o element <router-outlet>
							 <router-outlet></router-outlet>
							 
			9.5 - Criar component de login, separando os componentes
					 executar
					 #ng g c login 
						CREATE src/app/login/login.component.html (20 bytes)
						CREATE src/app/login/login.component.spec.ts (619 bytes)
						CREATE src/app/login/login.component.ts (271 bytes)     
						CREATE src/app/login/login.component.css (0 bytes)
						UPDATE src/app/app.module.ts (1504 bytes)
					
				9.5.1 - 
						- recortar todo o html do app.componet e deixar apenas o element <router-outlet>
						
						- colar em login.component.html
							
						- recortar do component app.component
							 /*ao instaciar essa classe*/
							  user =  {login : '', senha : ''}

							  /*criar constructor */
							  constructor (private loginServiceService : LoginServiceService){}

							  /*função que o botão acessar da tela de login */
							  public login(){
								this.loginServiceService.login(this.user);
								// console.log("Test Login " + this.user.login + "senha :" + this.user.senha)
							  }
							  
						 - e colar em login.component imporando o loginService

						- alterar o app.module para que	
							 {
								/*quando passar a url  http://localhost:4200/login ele vai chamar o componet LoginComponent*/
								path : 'login', component : LoginComponent
							  }
							
10 - Criando a Barra do Menu
		atualizar
			app.component.html
				<ul class="nav nav-tabs">
				  <li class="nav-item">
					<a class="nav-link active" [routerLink]="['/home']" routerLinkActive="router-link-active" >Home</a>
				  </li>
				  <li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Action</a>
					<div class="dropdown-menu">
					  <a class="dropdown-item" href="#">Link 1</a>
					  <a class="dropdown-item" href="#">Link 2</a>
					  <a class="dropdown-item" href="#">Link 3</a>
					</div>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" (click)="sair()">Exit</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link disabled" href="#">Disabled</a>
				  </li>
				</ul>
				<router-outlet></router-outlet>
	
		 app.component.ts
		 adicionar abaixo do Constructor
			 constructor(private router: Router) {
			}
			  /*se ao iniciar o sistema não tiver token vai para o login */
			  ngOnInit(): void {
				if (localStorage.getItem('token') == null) {
				  this.router.navigate(['login']);
				}
			  }
			  /*clicar em sair limpa token e  volta para login */
			  public sair(){
				localStorage.clear();
				this.router.navigate(['login']);
			  }
			}

11 - ]
	Criando um Interceptor
			executar	
			#ng g s HeaderInterceptor 
				CREATE src/app/service/header-interceptor.service.spec.ts (413 bytes)        
				CREATE src/app/service/header-interceptor.service.ts (146 bytes)
					
					atualizar
						import {
						  HttpErrorResponse,
						  HttpEvent,
						  HttpHandler,
						  HttpInterceptor,
						  HttpRequest,
						  HttpResponse,
						  HTTP_INTERCEPTORS,
						} from '@angular/common/http';
						import { Injectable, NgModule } from '@angular/core';
						import { throwError, Observable } from 'rxjs';
						import { catchError, tap } from 'rxjs/operators';

						@Injectable()

						/*toda requisição essa classe sera chamada para colocar o token no backend*/
						export class HeaderInterceptorService implements HttpInterceptor {
						  /*metodo criado conformde segustão da IDE*/
						  intercept(
							req: HttpRequest<any>,
							next: HttpHandler
						  ): Observable<HttpEvent<any>> {
							/*se token é diferente de null então criar */
							if (localStorage.getItem('token') !== null) {
							  const token = 'Bearer ' + localStorage.getItem('token');
							  /*sobrescrevendo a parte da requisição e vai passar a requisição pelo cabeçalho*/
							  const tokenRequest = req.clone({
								headers: req.headers.set('Authorization', token)
							  });
							  /*continuar "next" e passar a requisição com o tokenRequest*/
							  return next.handle(tokenRequest).pipe(
								tap((event: HttpEvent<any>) => {
								  if (
									event instanceof HttpResponse &&
									(event.status === 200 || event.status === 201)
								  ) {
									console.info('Sucesso na Operação');
								  }
								}),
								catchError(this.processaError)
							  );
							} else {
							  /*senão tem token passa requisição original */
							  return next.handle(req).pipe(catchError(this.processaError));
							}
						  }
						  constructor() {}

						  processaError(error: HttpErrorResponse) {
							let errorMessage = 'Erro desconhecido';
							if (error.error instanceof ErrorEvent) {
							  console.error(error.error);
							  errorMessage = 'Error: ' + error.error.error;
							} else {
							  errorMessage =
								'Código: ' + error.error.code + '\nMensagem: ' + error.error.error;
							}
							window.alert(errorMessage);
							return throwError(errorMessage);
						  }
						}

						/*transfomando em um modulo essa requisição */
						@NgModule({
						  providers: [
							{
							  provide: HTTP_INTERCEPTORS,
							  useClass: HeaderInterceptorService,
							  multi: true,
							},
						  ],
						})
						/*exportando essa classe em um modulo*/
						export class HttpInterceptorModule {}

					11.1 - ]
						impotar
						import { HttpInterceptorModule } from './service/header-interceptor.service'
						
							HttpInterceptorModule
							
12 - ]
	Class Model e Service do Usuário
		executar	
			#ng g s userService        
				CREATE src/app/service/user-service.service.spec.ts (383 bytes)
				CREATE src/app/service/user-service.service.ts (140 bytes)
				
	
						
					