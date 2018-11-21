import {Room} from './room';

export class Employee {
  constructor(public name: string, public surname: string, public birthDate: Date, public universityNick: string, public room: Room) {}
}
