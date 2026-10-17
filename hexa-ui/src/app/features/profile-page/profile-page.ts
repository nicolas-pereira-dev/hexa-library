import { Component, Input, OnInit, Signal } from "@angular/core";
import { User } from "../../models/user";
import { AuthenticationService } from "../../services/authentication/authentication-service";

@Component({
    selector: 'app-profile-page',
    imports: [],
    templateUrl: './profile-page.html',
    styleUrl: './profile-page.css',
})
export class ProfilePage {
    userSignal: Signal<User>;

    constructor(private authenticationService: AuthenticationService) {
        this.userSignal = this.authenticationService.userSignal;
    }

    logout() {
        this.authenticationService.logOut();
    }

}