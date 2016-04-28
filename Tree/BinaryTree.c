
#include<stdlib.h>
#include<stdio.h>




typedef struct NODE{

	int data;
	struct NODE* link;

}NODE;

int main(){


	printf("hi");

	NODE* n1 = (NODE *)malloc(sizeof(NODE));
	n1->data = 1;
	n1->link = NULL;

	printf("%d",n1->data);
}


