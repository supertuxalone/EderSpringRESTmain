"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.UserComponentComponent = void 0;
var core_1 = require("@angular/core");
var UserComponentComponent = /** @class */ (function () {
    /*declaração de userservice */
    function UserComponentComponent(userServiceService) {
        this.userServiceService = userServiceService;
    }
    UserComponentComponent.prototype.ngOnInit = function () {
        var _this = this;
        /*carregando os usuarios e joga o resultado na variavel students */
        this.userServiceService.getStudentList().subscribe(function (data) {
            _this.students = data;
        });
    };
    UserComponentComponent = __decorate([
        core_1.Component({
            selector: 'app-userComponent',
            templateUrl: './userComponent.component.html',
            styleUrls: ['./userComponent.component.css']
        })
    ], UserComponentComponent);
    return UserComponentComponent;
}());
exports.UserComponentComponent = UserComponentComponent;
