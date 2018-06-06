import {AfterViewInit, Component, Input, OnChanges, OnInit, ViewChild} from '@angular/core';
import {Score} from '../../model/Score';
import {jqxDataTableComponent} from 'jqwidgets-framework/jqwidgets-ts/angular_jqxdatatable';

@Component({
  selector: 'scores',
  templateUrl: './scores.component.html',
  styleUrls: ['./scores.component.css']
})
export class ScoresComponent implements OnChanges, AfterViewInit {
  @Input() scores: Score[] = [];
  @Input() update = false;
  data: any[] = this.generateData();
  @ViewChild('myTable') myGrid: jqxDataTableComponent;

  source: any =
    {
      localdata: this.data,
      datafields:
        [
          { name: 'studentName', type: 'string' },
          { name: 'studentSurname', type: 'string' },
          { name: 'index', type: 'string' },
          { name: 'group', type: 'string' },
          { name: 'score', type: 'string' },
          { name: 'value', type: 'string' }
        ],
      datatype: 'array'
    };

  dataAdapter: any = new jqx.dataAdapter(this.source);

  cellClass = (row: any, dataField: any, cellText: any, rowData: any): string => {
    const cellValue = rowData[dataField];
    switch (dataField) {
      case 'value':
        if (cellValue < 3) {
          return 'negative';
        }
        return 'positive';
    }
  }

  columns: any[] =
    [
      { text: 'Name', datafield: 'studentName', columngroup: 'StudentDetails',  width: 125 },
      { text: 'Surname', datafield: 'studentSurname', columngroup: 'StudentDetails', width: 125 },
      { text: 'Index', datafield: 'index', columngroup: 'StudentDetails', width: 75 },
      { text: 'Group', datafield: 'group', columngroup: 'StudentDetails', width: 125 },
      { text: 'Score', datafield: 'score', width: 100 },
      { text: 'Value', datafield: 'value',  cellsAlign: 'center', width: 50, cellClassName: this.cellClass}
    ];

    columngroups: any[] =
    [
      { text: 'Student Details', align: 'center', name: 'StudentDetails' }
    ];

  generateData(): any[] {
    const newScores = new Array();
    for (const score of this.scores) {
      const newScore = {
        studentName: score.student.name ,
        studentSurname: score.student.surname,
        index: score.student.index,
        group: score.student.group.name + ', ' + score.student.group.specialization.name + ' ' + score.student.group.year,
        score: score.name,
        value: score.value,
      };
      newScores.push(newScore);
    }
    return newScores;
  }

    ngOnChanges() {
    if (this.update) {
      this.updateGrid();
    }
  }

  updateGrid() {
    this.source.localdata = this.generateData();
    this.myGrid.updateBoundData();
  }

  ngAfterViewInit(): void {
    this.updateGrid();
  }
}
