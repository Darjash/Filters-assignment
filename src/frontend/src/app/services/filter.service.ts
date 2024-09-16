import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Filter } from '../filter.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilterService {
  private baseUrl = 'http://localhost:8080/filters';
  constructor(private http: HttpClient) { }

  getAllFilters(): Observable<Filter[]> {
    return this.http.get<Filter[]>(this.baseUrl);
  }

  createFilter(filter: Filter): Observable<Filter> {
    return this.http.post<Filter>(`${this.baseUrl}/add`, filter);
  }

  deleteFilter(id: number): Observable<Filter> {
    return this.http.delete<Filter>(`${this.baseUrl}/delete/${id}`);
}
}
