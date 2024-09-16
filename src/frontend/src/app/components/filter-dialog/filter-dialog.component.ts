import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Filter, FilterCriteria } from '../../filter.model';
import { FilterService } from '../../services/filter.service';

@Component({
  selector: 'app-filter-dialog',
  templateUrl: './filter-dialog.component.html',
  styleUrl: './filter-dialog.component.css'
})
export class FilterDialogComponent {

  @Input() isOpen: boolean = false; 
  @Input() isModal: boolean | undefined;
  @Output() close = new EventEmitter<void>();
  @Output() callLoadFilters = new EventEmitter<void>();

  constructor(private filterService: FilterService) { }

  filter: Filter = { name: '', criteria: [] };

  typeOptions = ['Amount', 'Title', 'Date'];

  descriptionOptions: { [key: string]: string[] } = {
    'Amount': ['More', 'Less', 'Equals'],
    'Title': ['Starts with', 'Ends with', 'Contains', 'Equals'],
    'Date': ['From', 'At', 'Before']
  };
  
  errorMessage: string = '';

  ngOnInit() {
    this.addCriteria();
  }

  closeModal() {
    this.isOpen = false;
    this.filter.name = '';
    this.filter.criteria = [{
      type: 'Amount', 
      description: this.descriptionOptions['Amount'][0],
      filterValue: ''
    }];
    this.errorMessage = '';
    this.close.emit();
  }

  addCriteria() {
    this.filter.criteria.push({
      type: 'Amount', 
      description: this.descriptionOptions['Amount'][0],
      filterValue: ''
    });
    this.errorMessage = '';
  }

  removeCriteria(index: number) {
    this.filter.criteria.splice(index, 1);
    this.errorMessage = '';
  }

  updateDescriptionOptions(criteria: FilterCriteria) {
    criteria.description = this.descriptionOptions[criteria.type][0];
  }

  validateFields(): boolean {
    if (!this.filter.name) {
      this.errorMessage = 'Filter name is required!';
      return false;
    }
    for (let criteria of this.filter.criteria) {
      if (!criteria.type || !criteria.description || !criteria.filterValue) {
        this.errorMessage = 'All criteria fields must be filled!';
        return false;
      }
    }
    return true;
  }

  loadFilters(): void {
    this.filterService.createFilter(this.filter);
  }

  saveFilter() {
    if (this.validateFields()) {
      this.filterService.createFilter(this.filter).subscribe(() => {
        this.callLoadFilters.emit();
    });
      this.closeModal();
    }
  }   
}
