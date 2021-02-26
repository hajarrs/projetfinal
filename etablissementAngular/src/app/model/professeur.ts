import { Matiere } from "./matiere";
import { Utilisateur } from "./utilisateur";

export class Professeur extends Utilisateur {
    private _matieres: Matiere[] = [];

	

	constructor(matieres: Matiere[] ) {
        super();
		this._matieres = matieres;
	}


}
