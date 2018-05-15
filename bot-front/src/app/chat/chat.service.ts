import {AfterViewChecked, AfterViewInit, Injectable, OnInit} from '@angular/core';

import { ApiAiClient } from 'api-ai-javascript';

import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { environment } from '../../environments/environment';
import {Message} from '../shared/Message';

// Message class for displaying messages in the component


@Injectable()
export class ChatService {

  readonly token = environment.dialogflow.angularBot;
  readonly client = new ApiAiClient({ accessToken: this.token });

  conversation = new BehaviorSubject<Message[]>([]);

  constructor() {}

  // Sends and receives messages via DialogFlow
  converse(msg: string) {
    const userMessage = new Message(msg, 'user');
    this.update(userMessage);

    return this.client.textRequest(msg)
      .then(res => {
        console.log(res);
        const speech = res.result.fulfillment.speech;
        const role = res.result['parameters']['Role'];
        const actionType = res.result['parameters']['ActionType'];
        const date = res.result['parameters']['date-time'];
        const botMessage = new Message(speech, 'bot');
        this.update(botMessage);

      });
  }



  // Adds message to source
  update(msg: Message) {
    this.conversation.next([msg]);
  }

}
