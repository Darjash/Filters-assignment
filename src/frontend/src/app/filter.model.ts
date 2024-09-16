export interface FilterCriteria {
  id?: number;
  type: string;
  description: string;
  filterValue: string;
}

export interface Filter {
  id?: number;
  name: string;
  criteria: FilterCriteria[];
}