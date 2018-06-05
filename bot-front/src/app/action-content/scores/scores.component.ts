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
      { text: 'Name', datafield: 'studentName', columngroup: 'StudentDetails',  width: 120 },
      { text: 'Surname', datafield: 'studentSurname', columngroup: 'StudentDetails', width: 120 },
      { text: 'Index', datafield: 'index', columngroup: 'StudentDetails', width: 180 },
      { text: 'Group', datafield: 'group', columngroup: 'StudentDetails', width: 80 },
      { text: 'Score', datafield: 'score', width: 90 },
      { text: 'Value', datafield: 'value',  cellsAlign: 'right', cellClassName: this.cellClass}
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
        group: score.student.group.name,
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

  // ngAfterViewInit() {
  //   this.updateGrid();
  // }

//
//   constructor() { }
//
//   source: any =
//     {
//       localdata: [{
//         name: 'test',
//         surname: 'test',
//         index: 'test',
//         group: 'test',
//         score: 'test',
//         value: 1
//       }],
//       datatype: 'array',
//       datafields: [
//         { name: 'name', type: 'string' },
//         { name: 'surname', type: 'string' },
//         { name: 'index', type: 'string' },
//         { name: 'group', type: 'string' },
//         { name: 'score', type: 'string' },
//         { name: 'value', type: 'number' }
//       ]
//     };
//   dataAdapter: any = new jqx.dataAdapter(this.source);
//   //

//
// // , cellsrenderer: this.cellsrenderer
//
//
//   columns: any[] =
//     [
//       { text: 'Name', datafield: 'name', width: 150 },
//       { text: 'Surname', datafield: 'surname', width: 150 },
//       { text: 'Index', datafield: 'index', width: 50},
//       { text: 'Group', datafield: 'group', width: 150},
//       { text: 'Score Details', datafield: 'score', align: 'center', width: 150 },
//       { text: 'Value', datafield: 'value', width: 50 }
//     ];
//   //

//
//

//
//
//
//   private generateScores(): any[] {
//     const newScores = new Array();
//     for (const score of this.scores) {
//       const newScore = {
//         name: score.student.name ,
//         surname: score.student.surname,
//         index: score.student.index,
//         group: score.student.group.name,
//         score: score.name,
//         value: score.value,
//       };
//       newScores.push(newScore);
//     }
//     return newScores;
//   }
}
