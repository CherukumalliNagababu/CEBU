package PageObjects;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;







public class CebuPage extends BaseClass {

	private static WebElement element;
	
	
	public CebuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement pop_Up() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("popup"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement ScrollDown() throws Exception {
		element = null;
		try {
			PageUtils.scrollDown(driver);
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement oneyWay() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='flightType']//div[2]//label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement roundTrip() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='flightType']//div[1]//label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement multiCity() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='multicity']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_From() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("FromStation"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_To() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("ToStation"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement header_Month_D(String HeaderMonth) throws Exception {
		element = null;
		try {
			for(int i=0;i<=5;i++){
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Departing On:'])[1]/following::span[5]"));
			if(element.getText().equals(HeaderMonth))
			{
				System.out.println(element.getText());
				break;
			}
			else{
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Departing On:'])[1]/following::span[6]")).click();
			}
			}
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Date_D(String Date) throws Exception {
		List<WebElement> element = null;
		Date mDate = new Date();
		 DateFormat date = new SimpleDateFormat("dd");
		 String currentDate=date.format(mDate);
			//element = driver.findElement(By.xpath("//div[@class='calendar left single']//td[not(contains(@class,'off available'))]"));
			try{
				if(currentDate.equals(Date))
				{
					driver.findElement(By.xpath("//table[@class='calendar']//tbody/tr/td[@class='day selected departure-date']")).click();
					
				}
				else{
					
				 element = driver.findElements(By.xpath("//table[@class='calendar']//tbody/tr/td[@class='day']"));
				 for (WebElement e1 : element) {
						String ele = e1.getText();
						

						if (ele.equals(Date)) {
							System.out.println("OneWay:Select Date:"+e1.getText());
							e1.click();	
							break;
						}
						// Thread.sleep(1000);
					}
				
				}
		
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	
	
	public static WebElement adult_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(2-11 years)'])[2]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement child_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(Under 2 years)'])[2]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement infant_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Promo Code'])[1]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_FindFlight() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//strong[contains(text(),'FIND FLIGHTS')]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement flight_Numbers(String FlightNUM) throws Exception {
		element = null;
		try {
			List<WebElement> element = driver.findElements(By.xpath("//table[@id='depart-table']//tbody/tr/th/div[1]"));
			List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			//System.out.println("element.size:"+element.size());
			for(WebElement e:element)
			{
				System.out.println(e.getText());
			}
			
			for(int i=1;i<=element.size();i++)
			{
				//System.out.println(11);
				        if (driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/th/div[1]")).getText().equals(FlightNUM))
						{
				        	String FlightNumber=driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/th/div[1]")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber);
				        	if("FLY ONLY".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[5]")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[6]")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE + MEAL".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[7]")).click();
				        		
				        	}
				        
				        	
						  
						    break;
						}
				        

				       
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("FLIGHT NUMBER DOES NOT FOUND");
			throw (e);
			
		}
		return element;
	}
	
	public static WebElement WebSite_Amount() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//p[@class='amount']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Continue_Srp() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("submit_search_button"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Alert_close() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[@id='int-flight-reminder-modal-close']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_continueGuestToggleBar() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("continueGuestToggleBar"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-2"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-3"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-4"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-5"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-6"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-7"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-8"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-9"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	
	public static WebElement Clk_Forward() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@class='arrow forward']//a"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement tabs() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//a[@id='guest-tab-link-4']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	//***********************************
	public static WebElement drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='passengers_0__Name_Title-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Value(String Value) throws Exception {
		List<WebElement> element = null;
		try {
			element = driver.findElements(By.xpath("//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']/ul/li"));
			
				for (WebElement e1 : element) {
					String ele = e1.getText();
					

					if (ele.equals(Value)) {
						System.out.println("Select Value:"+e1.getText());
						e1.click();	
						break;
					}
			}
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_0__Name_First"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_0__Name_Last"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='nationality_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	
	//***********************************
	public static WebElement drp_title_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='passengers_1__Name_Title-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	
	public static WebElement firstname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_1__Name_First"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_1__Name_Last"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='nationality_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	
	
	//***********************************
		public static WebElement drp_title_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='passengers_2__Name_Title-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		
		public static WebElement firstname_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("cebPassengers_2__Name_First"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement lastname_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("cebPassengers_2__Name_Last"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement drp_date_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement drp_month_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement drp_year_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement btn_Nationality_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='nationality_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		
		//***********************************
				public static WebElement drp_title_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_3__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_3__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_3__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				//***********************************
				public static WebElement drp_title_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_4__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_4__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_4__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
		
				//***********************************
				public static WebElement drp_title_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_5__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_5__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_5__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				//***********************************
				public static WebElement drp_title_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_6__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_6__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_6__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				//***********************************
				public static WebElement drp_title_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_7__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_7__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_7__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				//***********************************
				public static WebElement drp_title_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_8__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_8__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_8__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				//*************************** Infants
		
				public static WebElement I_drp_title_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_0__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_0__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_0__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				//*************************** 
				
				public static WebElement I_drp_title_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_1__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_1__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_1__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_2__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_2__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_2__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_3__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_3__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_3__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_4__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_4__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_4__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_5__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_5__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_5__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_6__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_6__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_6__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_7__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_7__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_7__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement btn_Continue_Passenger() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submit_search_button"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement PopUp_No_Meal() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//button[@id='noMealConfirmationNo']"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Proceed_Yes() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("buttonProceedConfirmationYes"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_submitPhTravelTax() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submitPhTravelTax"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement chk_Agree() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pre-paid Baggage'])[1]/preceding::ins[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Confirm_Continue() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("bookingRecapOK"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				//Contact Information
				
				
				
				public static WebElement contact_number_CountryCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebContactPayment_HomePhoneCountryCode-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement contact_number() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_HomePhone"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement Alt_Contact_number_CountryCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebContactPayment_OtherPhoneCountryCode-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement Alt_Contact_number() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_OtherPhone"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement contact_Email() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_EmailAddress"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement contact_Confirm_Email() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_ConfirmEmail"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_creditCard() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//label[@class='credit-card-tab']"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement txt_cardNumber() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Card Number*'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement txt_validationNumber() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Validation Number'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_Exp_Month() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebExternalPayment_expMonth0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement drp_Exp_Year() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebExternalPayment_expYear0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_CardHolder_First_Name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cardholder Name:'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_CardHolder_Last_Name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cardholder Name:'])[1]/following::input[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				
				public static WebElement txt_Street_Address() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Street Address*'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_city_name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City*'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement billing_Country_Code() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City*'])[1]/following::span[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement billing_state() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country*'])[2]/following::span[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement billing_ZipCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Zip Code'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement chk_Privacy() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]/preceding::ins[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Submit_Card() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submit_search_button"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				// Passport Details 1
				
				
				
				public static WebElement txt_Passport_Num_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_0"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement chk_Pasport_In_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]/preceding::div[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 2
				
				
				
				public static WebElement txt_Passport_Num_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_1"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 3
				
				
				
				public static WebElement txt_Passport_Num_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_2"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 4
				
				
				
				public static WebElement txt_Passport_Num_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 5
				
				
				
				public static WebElement txt_Passport_Num_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_4"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 6
				
				
				
				public static WebElement txt_Passport_Num_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_5"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 7
				
				
				
				public static WebElement txt_Passport_Num_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_6"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 8
				
				
				
				public static WebElement txt_Passport_Num_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_7"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
// Passport Details 9
				
				
				
				public static WebElement txt_Passport_Num_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_8"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
}