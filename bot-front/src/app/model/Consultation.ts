import {Room} from './room';
import {Employee} from './Employee';

export class Consultation {
  constructor(public dateStart: Date, public dateEnd: Date, public employee: Employee, public room: Room) {}
}
