import {Component, Input, OnInit} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {Score} from '../../model/Score';
import {ScoresService} from '../../shared/scores.service';

@Component({
  selector: 'scores',
  templateUrl: './scores.component.html',
  styleUrls: ['./scores.component.css']
})
export class ScoresComponent implements OnInit {
  @Input() scores: Score[];
  constructor() { }

  ngOnInit() {
  }

}
