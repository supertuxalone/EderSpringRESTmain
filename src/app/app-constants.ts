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
