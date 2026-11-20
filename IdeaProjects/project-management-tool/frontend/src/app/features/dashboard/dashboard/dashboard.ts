
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DashboardService } from '../../../core/services/dashboard.service';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard implements OnInit {

  statistics: any = {};

  constructor(
    private router: Router,
    private dashboardService: DashboardService
  ) {}

  ngOnInit(): void {
    this.loadDashboardStatistics();
  }

  loadDashboardStatistics(): void {
    this.dashboardService.getDashboardStatistics().subscribe({
      next: (response) => {
        this.statistics = response;
      },
      error: (error) => {
        console.error('Error loading dashboard statistics:', error);
      }
    });
  }

  logout(): void {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}
