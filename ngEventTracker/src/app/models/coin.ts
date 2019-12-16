import { Time } from '@angular/common';
import { Portfolio } from 'src/app/models/portfolio';

export class Coin {
  id: number;
  logo: string;
  name: string;
  tradingPair: string;
  exchange: string;
  purchaseDate: Date;
  purchaseTime: Time;
  buyPrice: number;
  amountPurchased: number;
  exchangeFee: number;
  notes: string;
  portfolio: Portfolio;

  constructor(
    id?: number,
    logo?: string,
    name?: string,
    tradingPair?: string,
    exchange?: string,
    purchaseDate?: Date,
    purchaseTime?: Time,
    buyPrice?: number,
    amountPurchased?: number,
    exchangeFee?: number,
    notes?: string,
    portfolio?: Portfolio


  ) {
    this.id = id;
    this.logo = logo;
    this.name = name;
    this.tradingPair = tradingPair;
    this.exchange = exchange;
    this.purchaseDate = purchaseDate;
    this.purchaseTime = purchaseTime;
    this.buyPrice = buyPrice;
    this.amountPurchased = amountPurchased;
    this.exchangeFee = exchangeFee;
    this.notes = notes;
    this.portfolio = portfolio;
  }
}
