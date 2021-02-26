import { Matiere } from "./matiere";
import { Utilisateur } from "./utilisateur";

export class Professeur extends Utilisateur {
    private _matieres: Matiere[] = [];

	

	constructor(matieres?: Matiere[]) {
        super();
        
	}


    /**
     * Getter matieres
     * @return {Matiere[] }
     */
	public get matieres(): Matiere[]  {
		return this._matieres;
	}

    /**
     * Setter matieres
     * @param {Matiere[] } value
     */
	public set matieres(value: Matiere[] ) {
		this._matieres = value;
	}

	
}
