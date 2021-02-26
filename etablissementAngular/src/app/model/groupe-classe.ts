import { Professeur } from "./professeur";

export class GroupeClasse {

    private _id: number;
    private _nom: string;
    private _professeurPrincipal: Professeur;


	constructor(id: number, nom: string, professeurPrincipal: Professeur) {
		this._id = id;
		this._nom = nom;
		this._professeurPrincipal = professeurPrincipal;
	}

}
