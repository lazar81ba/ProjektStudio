import {Group} from './group';

export class Student {
  constructor(public name: string, public surname: string, public birthDate: Date, public sex: string, public index: number, public group: Group) {}
}
