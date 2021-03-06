export class Adresse {
    private _id!: number;
    private _numRue: number;
    private _nomRue: string;
    private _codePostal: string;
    private _ville: string;


	constructor(id?: number, numRue: number = 0, nomRue: string='', codePostal:string='', ville: string='') {
		this._numRue = numRue;
		this._nomRue = nomRue;
        this._codePostal = codePostal;
		this._ville = ville;
	}


    /**
     * Getter codePostal
     * @return {string}
     */
	public get codePostal(): string {
		return this._codePostal;
	}

    /**
     * Setter codePostal
     * @param {string} value
     */
	public set codePostal(value: string) {
		this._codePostal = value;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter numRue
     * @return {number}
     */
	public get numRue(): number {
		return this._numRue;
	}

    /**
     * Getter nomRue
     * @return {string}
     */
	public get nomRue(): string {
		return this._nomRue;
	}

    /**
     * Getter ville
     * @return {string}
     */
	public get ville(): string {
		return this._ville;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter numRue
     * @param {number} value
     */
	public set numRue(value: number) {
		this._numRue = value;
	}

    /**
     * Setter nomRue
     * @param {string} value
     */
	public set nomRue(value: string) {
		this._nomRue = value;
	}

    /**
     * Setter ville
     * @param {string} value
     */
	public set ville(value: string) {
		this._ville = value;
	}


}
