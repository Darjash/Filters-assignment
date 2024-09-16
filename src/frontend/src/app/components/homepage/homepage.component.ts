import { Component } from '@angular/core';
import { Filter } from '../../filter.model';
import { FilterService } from '../../services/filter.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  filters: Filter[] = [];
  isModalOpen = false;
  isModalState = true;

  constructor(private filterService: FilterService) { }
  
  ngOnInit(): void {
    this.loadFilters();
  }

  loadFilters(): void {
    this.filterService.getAllFilters().subscribe(filters => this.filters = filters);
  }

  openFilterModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }

  changeModalState(){
    this.isModalState = !this.isModalState;
  }

  deleteFilter(id: number){
    this.filterService.deleteFilter(id).subscribe(() => {
      this.loadFilters();
    });
  }
}
