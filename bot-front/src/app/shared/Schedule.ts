
import {Group} from './group';
import {Room} from './room';
import {Subject} from './subject';

export class Schedule {
  constructor(public dateEnd: Date, public dateStart: Date, public group: Group, public room: Room, public subject: Subject) {}
}
