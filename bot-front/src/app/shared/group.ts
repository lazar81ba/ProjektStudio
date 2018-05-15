///<reference path="specialization.ts"/>
import {Specialization} from './specialization';

export class Group {
  constructor(public name: string, public specialization: Specialization, public year: number) {
  }
}
