import {Room} from './room';
import {Employee} from './Employee';

export class Consultation {
  constructor(public dataStart: Date, public dateEnd: Date, public employee: Employee, public room: Room) {}
}
